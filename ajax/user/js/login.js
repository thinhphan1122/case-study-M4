$(document).ready(function () {
    $("#loginForm").submit(function (e) {
        e.preventDefault();

        let username = $("#loginUsername").val();
        let password = $("#loginPassword").val();

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/users/login",
            contentType: "application/json",
            data: JSON.stringify({
                username: username,
                password: password
            }),
            success: function (response) {

                alert("welcome "+ response.username)
                window.location.href = 'index.html';

            },
            error: function (xhr) {
                if (xhr.status >= 400 && xhr.status < 500) {
                    alert("đăng nhập không hợp lệ");
                } else if (xhr.status >= 500) {
                    alert("Lỗi server");
                }
            }
        });
    });
});
