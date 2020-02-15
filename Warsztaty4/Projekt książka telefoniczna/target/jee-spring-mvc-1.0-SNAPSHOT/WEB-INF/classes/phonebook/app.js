$(function () {


    let list = $(".book-list");
    console.log("list", list);
    $(".show-books").on("click", function () {
        let btn = $(this);

        btn.addClass("loading");
        btn.prop("disabled", true);

        //wykonanie połączenia
        $.ajax({
            url: "http://localhost:8282/books",
            type: "GET",
            data: {},
            dataType: "json"

        }).done(function (response) {
            list.empty();
            bookList(response);
        }).fail(function (err) {
            console.log(err)
        }).always(function () {
            btn.removeClass('loading');
            btn.prop('disabled', false);
        });
    });


    function bookList(books) {
        books.forEach(function (book) {
            list.append($(`<li>${book.title}</li>`));

            let detailsButton = $("<button class='details' data-id=" + book.id + "> Details </button> ");
            let deleteButton = $("<button class='delete' data-id=" + book.id + "> Delete </button> ");

            list.append(detailsButton);
            list.append(deleteButton);
        })
    }




    //wyświetlenie szczegółów klikniętej książki:

    let bookDetails = $(".book-details");
    console.log("bookdetails", bookDetails);
    bookDetails.hide();

    list.on("click", 'button.details', function () {
        let btnId = $(this).attr("data-id");
        bookDetails.toggle(); //???

        $.ajax({
            url: "http://localhost:8282/books/" + btnId,
            data: {},
            type: "GET",
            dataType: "json"

        }).done(function (response) {
            showBook(response);
        }).fail(function (err) {
            console.log("Connection error", err)
        });


    });

    function showBook(book) {
        let id = book.id;
        let button = $("button[data-id="+id +"].details");

        bookDetails.html(
            "<div>ID: " + book.id + ",</div> " +
            "<div>ISBN: " + book.isbn + ",</div>" +
            "<div>TITLE: " + book.title + ",</div>" +
            "<div>AUTHOR: " + book.author + ", </div>" +
            "<div>PUBLISHER: " + book.publisher + ", </div>" +
            "<div>TYPE: " + book.type + ", </div>");

    }


    //FORMULARZ DODAWANIA KSIĄŻKI

    let bookForm = $(".book-form");
    console.log("book form", bookForm);
    bookForm.hide();

    $(".add-button").on("click", function (e) {
        $(this).next().toggle();
    });

//DODAWANIE KSIĄŻKI

    let isbn = $("#isbn");
    let title = $("#title");
    let author = $("#author");
    let publisher = $("#publisher");
    let type = $("#type");

    bookForm.on("submit", function () {

        //wysłanie danych - NIE WYSYŁA!!!
        $.ajax({
            url: "http://localhost:8282/books/",
            type: "POST", //wysłanie danych z formularza
            dataType: json,
            data: JSON.stringify({
                isbn: isbn,
                title: title,
                author: author,
                publisher: publisher,
                type: type
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }


        }).done(function (response) {
            console.log("book succesfully added")
        }).fail(function (err) {
            console.log(err)
        });

    });


    //USUWANIE KSIĄŻKI

    list.on("click", 'button.delete', function () {
        let btnId = $(this).attr("data-id"); //pobranie atrybutu tego buttona

        $.ajax({
            url: "http://localhost:8282/books/" + btnId,
            method: "DELETE"

        }).done(function (response) {
            console.log("book deleted")
        }).fail(function (err) {
            console.log(err)
        });

    });


});
