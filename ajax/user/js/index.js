function displayUsers() {
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/api/users",
            success: function(data) {

                let userTable = '<table>';
                userTable += '<tr>' +
                    '<th>ID</th>' +
                    '<th>Username</th>' +
                    '<th>Password</th>'
                    '</tr>';

                for(let i = 0; i < data.length; i++) {
                    userTable += '<tr>';
                    userTable += '<td>' + data[i].id + '</td>';
                    userTable += '<td>' + data[i].username + '</td>';
                    userTable += '<td>' + data[i].password + '</td>';
                }
                userTable += '</table>';

                $('#userList').html(userTable);
            }
        });
}
$(document).ready(displayUsers);

