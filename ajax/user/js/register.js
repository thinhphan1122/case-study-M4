$(document).ready(function () {
    $("#registerForm").submit(function (event) {
        event.preventDefault();
        let username = $("#registerUsername").val();
        let password = $("#registerPassword").val();
        let email = $("#registerEmail").val();

        let registerData = {
            username: username,
            password: password,
            email: email,
        };

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/api/users/register",
            contentType: "application/json",
            data: JSON.stringify(registerData),
            success: function (response) {
                console.log("Đăng ký thành công:", response);

                let confirmation = confirm("Đăng ký thành công! Bấm OK để đến trang đăng nhập.");

                if (confirmation) {
                    window.location.href = "login.html";
                }
            },
            error: function () {
                console.error();
                $("#errorContainer").text("Đăng ký không thành công. Vui lòng kiểm tra thông tin và thử lại.");
            }
        });
    });
})

