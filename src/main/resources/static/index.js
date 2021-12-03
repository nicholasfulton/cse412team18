$(function () {
    localStorage.clear();
    $("#submit").click(submit);
    $("#skip").click(skip);
});

function submit() {
    var phoneNumber = $("#phoneNumber").val();
    $.get(`/member?phoneNumber=${encodeURIComponent(phoneNumber)}`, data => {
        if (!data) {
            alert('User not found');
        }
        else {
            localStorage.setItem('member', JSON.stringify(data));
            window.location.href = "products.html";
        }
    });
}

function skip() {
    localStorage.setItem('member', 'null');
    window.location.href = "products.html";
}