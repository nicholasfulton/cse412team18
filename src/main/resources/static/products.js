$(function () {
    //localStorage.clear();

    $.get('/product/all', (data) => {
        var ul = $('#itemlist');
        data.forEach(item => {
            var li = $('<li/>')
                .text(item.displayName + " ")
                .appendTo(ul);
            
            $('<a/>')
                .text("Add")
                .attr("href", "#")
                .click(item.id, click)
                .appendTo(li);
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