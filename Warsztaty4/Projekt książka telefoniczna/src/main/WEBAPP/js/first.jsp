<%--
  Created by IntelliJ IDEA.
  User: Jola
  Date: 2020-01-30
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
$(function(){
var context = window.location.pathname;
function ajax() {
var startOption = {
url: context+"books/",
data: {},
method: "GET",
dataType: "json",
contentType: "application/json",
async: false
};

if (arguments.length>0) {
startOption.url = context+$(arguments[0]).data('url');
console.log(startOption.url);
startOption.method = $(arguments[0]).data('type');
}
// zamiana tabeli na obiekt
if (arguments.length>1) {
var result = {};
for (var i=0; i<arguments[1].length; i++) {
result[arguments[1][i].name] = arguments[1][i].value;
}
startOption.data = JSON.stringify(result);
}

return $.ajax(startOption).done(function (result) {
}).fail(function (xhr, status, err) {
}).always(function (xhr, status) {
}).responseJSON;
}

// set form action
var formPhoneBook = $('#addPhoneBook');
formBook.on('submit', function(e){
e.preventDefault();
console.log(this);
ajax(this,$(this).serializeArray());
refreshPhoneBooks();
});

function refreshPhoneBooks() {
var result = ajax();
var list = $('#phonebook-list');

list.html('');

for (element of result) {
var row = $(
'<div class="card">' +
'<div class="card-header">' +
'<div class="row mb-0">' +
'<div class="col-10 book-title" data-url="phonebooks/'+element.id+'" data-type="GET">' + element.title + '</div>' +
'<div class="col-2"><button type="button" class="btn btn-danger book-delete" data-type="DELETE" data-url="/phonebooks/'+element.id+'">Usuń</button></div>' +
'</div>' +
'</div>' +
'<div class="collapse" style="display:none">' +
'<div class="card-body">' +
'<form class = "phonebookForm" data-url="phonebooks/" data-type="PUT">'+
'<div class="form-group row"><label for="phonebookId" class="col-sm-2 col-form-label">id</label><div class="col-sm-3">'+
'<input type="text" readonly class="form-control" id="phonebookId" placeholder="phonebookId" name="id"></div></div>'+
'<div class="form-group row"><label for="surname" class="col-sm-2 col-form-label">isbn</label><div class="col-sm-3">'+
'<input type="text" class="form-control" id="surname" placeholder="bookIsbn" name="surname"></div></div>'+
'<div class="form-group row"><label for="name" class="col-sm-2 col-form-label">title</label><div class="col-sm-3">'+
'<input minlength="2" type="text" class="form-control" id="name" placeholder="name" name="name"></div></div>'+
'<div class="form-group row"><label for="citi" class="col-sm-2 col-form-label">author</label><div class="col-sm-3">'+
'<input type="text" class="form-control" id="citi" placeholder="citi" name="citi"></div></div>'+
'<div class="form-group row"><label for="street" class="col-sm-2 col-form-label">citi</label><div class="col-sm-3">'+
'<input type="text" class="form-control" id="street" placeholder="street" name="flatnumber"></div></div>'+
'<div class="form-group row"><label for="flatnumber" class="col-sm-2 col-form-label">flatnumber</label><div class="col-sm-3">'+
'<input type="text" class="form-control" id="flatnumber" placeholder="flatnumber" name="type"></div></div>'+
'<div class="form-group row"><label for="phonenumber" class="col-sm-2 col-form-label">phonenumber</label><div class="col-sm-3">'+
'<input type="text" class="form-control" id="phonenumber" placeholder="phonenumber" name="type"></div></div>'+
'<div class="form-group row"><div class="col-sm-10"><button type="submit" class="btn btn-success book-update">Zmień</button></div></div>'+
'</form>' +
'</div>' +
'</div>' +
'</div>');

var formBook = row.find('.bookForm');

formBook.on('submit',function(e){
e.preventDefault();
ajax(this,$(this).serializeArray());
refreshBooks();
});

// dodwanie zadarzenia do elementu listy
row.find('.book-title').on('click', function () {
var collapse = $(this).parent().parent().parent().find('.collapse');
var ajaxResult = ajax(this);

var phonebookForm =collapse.find('.phonebookForm');

console.log(phonebookForm);

if (collapse.css('display') === 'none') {
collapse.css('display', 'block');
phonebookForm.find('[name=id]').attr('value',ajaxResult.id);
phonebookForm.find('[name=surname]').attr('value',ajaxResult.isbn);
phonebookForm.find('[name=name]').attr('value',ajaxResult.title);
phonebookForm.find('[name=phonenumber]').attr('value',ajaxResult.author);
phonebookForm.find('[name=citi]').attr('value',ajaxResult.publisher);
phonebookForm.find('[name=street]').attr('value',ajaxResult.type);
phonebookForm.find('[name=flatnumber]').attr('value',ajaxResult.type);

} else {
collapse.css('display', 'none');
bookForm.find('[type = text]').attr('value','');
}
});

var button = row.find('.phonebook-delete');
button.on('click', function() {
console.log(ajax(this));
refreshPhoneBook()
});
list.append(row);
}
}

refreshPhoneBook();
});
