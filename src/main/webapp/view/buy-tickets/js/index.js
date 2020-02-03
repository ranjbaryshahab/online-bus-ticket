function saveStudent() {

    const emailInput = document.getElementById('exampleInputEmail1');
    const passwordInput = document.getElementById('exampleInputPassword1');

    const email = emailInput.value;
    const password = passwordInput.value;

    const url = 'http://192.168.1.35:8081/student/save?email= ' + email + '&password=' + password;

    const http = new XMLHttpRequest();

    http.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            loadStudentsAjax();
            console.log('Student has been saved successfully. ');
            emailInput.value = '';
            passwordInput.value = '';
        }
    };

    http.open('GET', url, true);
    http.send();
}

function loadStudents() {
    const tableBody = document.getElementById("table-body");
    tableBody.innerHTML = '';

    let studentList = [
        {id: 32, email: 'b@c.com', password: 'pass1'},
        {id: 38, email: 's@c.com', password: 'pass2'},
        {id: 39, email: 'r@c.com', password: 'pass3'},
    ];

    let rows = '';
    for (let i = 0; i < studentList.length; i++) {
        rows += createRow(
            studentList[i].id,
            studentList[i].email,
            studentList[i].password
        );
    }

    tableBody.innerHTML = rows;
}

function loadStudentsAjax() {
    const tableBody = document.getElementById("table-body");
    tableBody.innerHTML = '';

    const http = new XMLHttpRequest();
    const url = 'http://192.168.1.35:8081/student/all';

    http.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const studentList = JSON.parse(this.responseText);
            let rows = '';
            for (let i = 0; i < studentList.length; i++) {
                rows += createRow(
                    studentList[i].id,
                    studentList[i].email,
                    studentList[i].password
                );
            }
            tableBody.innerHTML = rows;
        }
    }

    http.open('GET', url, true);
    http.send();
}

function createRow(id, email, password) {
    return '        <tr>\n' +
        '                <th scope="row">' + id + '</th>\n' +
        '                <td id="email' + id + '">' + email + '</td>\n' +
        '                <td id="password' + id + '">' + password + '</td>\n' +
        '                <td><button type="button" class="btn btn-danger" onclick="deleteStudent(' + id + ')">Delete</button><button type="button" class="btn btn-warning" onclick="fillForm(' + id + ')">Edit</button>\n</td>\n' +
        '            </tr>';
}

function fillForm(id) {
    const emailColumn = document.getElementById("exampleInputEmail2");
    const passwordColumn = document.getElementById("exampleInputPassword2");

    emailColumn.value = document.getElementById("email" + id).innerText;
    passwordColumn.value = document.getElementById("password" + id).innerText;

    document.getElementById("id").value = id;

}

function edit() {
    const studentId = document.getElementById("id");
    const exampleInputEmail2 = document.getElementById("exampleInputEmail2");
    const exampleInputPassword2 = document.getElementById("exampleInputPassword2");

    const email = exampleInputEmail2.value;
    const password = exampleInputPassword2.value;
    const id = studentId.value;

    const url = 'http://192.168.1.35:8081/student/edit?id=' + id + '&email=' + email + '&password=' + password;

    const http = new XMLHttpRequest();

    http.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            loadStudentsAjax();
            console.log('This student was edited. ');
        }
    };

    http.open('GET', url, true);
    http.send();
}

function deleteStudent(id) {
    const url = 'http://192.168.1.35:8081/student/remove?id=' + id;

    const http = new XMLHttpRequest();

    http.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            loadStudentsAjax();
            console.log('This student was edited. ');
        }
    };

    http.open('GET', url, true);
    http.send();
}

function showEditModal() {
    const exampleInputEmail2 = document.getElementById("exampleInputEmail2");
    const exampleInputPassword2 = document.getElementById("exampleInputPassword2");

    $("#exampleInputEmail2").value;
    $("");
}
