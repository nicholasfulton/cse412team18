$(function () {
    localStorage.clear();
});

function member(input){
    var memberInfo = databaseService.getMember(input);
    if(memberInfo)
        localStorage.setItem('member', true);
    else
        localStorage.setItem('member', false);
    
}

