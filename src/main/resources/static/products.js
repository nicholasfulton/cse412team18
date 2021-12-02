$(function () {
    localStorage.clear();

    $.get('/product/all', (data) => {
        var tbody = $('#products');
        data.forEach(item => {
            var tr = $('<tr/>')
                .appendTo(tbody);
            var td = $('<td/>')
                .text(item.displayName + " ")
                .appendTo(tr);
            var td = $('<td/>')
                .text(item.price/100 + " ")
                .appendTo(tr);
            var td = $('<td>')
                .text(item.stockCount + " ")
                .appendTo(tr);

            var td = $('<td/ style="text-align: center">')
                .appendTo(tr);

            $('<a/>')
                .text("Add")
                .attr("href", "#")
                .click(item.id, click)
                .appendTo(td);
           
        });
    });
});

function click(event) {
    var current = localStorage.getItem(event.data.toString());
    if (current)
        localStorage.setItem(event.data.toString(), Number.parseInt(current) + 1);
    else
        localStorage.setItem(event.data.toString(), 1);
}