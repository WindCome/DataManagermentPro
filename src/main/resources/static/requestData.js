//登录
function login() {
    let user={
        userName:"abcd",
        passWord:"12345"
    };
    alert(JSON.stringify(user));
    $.ajax({
        type: "POST",
        url: "/login/password",
        data: JSON.stringify(user),
        datatype:"json",
        contentType:"application/json",
        success: function (data) {
            alert(data);
        }
});

}