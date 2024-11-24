document.addEventListener('DOMContentLoaded', startEvents, false);

var userType;

function startEvents() {

    var form = document.getElementById('form');
    var padre = document.getElementById('padre');
    var profesor = document.getElementById('profesor');
    var dropBtn = document.getElementById('dropBtn');
    var subBtn = document.getElementById('enviar');
    var inputEmail = document.getElementById('email');
    var inputPassword = document.getElementById('password');
    var errorEmail = document.getElementById('error-mail');
    var errorPassword = document.getElementById('error-password');

    dropBtn.addEventListener('click', function(e) {

        e.preventDefault();

    }), true;

    padre.addEventListener('click', function(e) {

        e.preventDefault();
        userType = 'padre';
        dropBtn.textContent = "Padre seleccionado";
        document.getElementById('email').disabled = false;
        document.getElementById('password').disabled = false;
        subBtn.disabled = false;

    });

    profesor.addEventListener('click', function(e) {

        e.preventDefault();
        userType = 'profesor';
        dropBtn.textContent = "Profesor seleccionado";
        var inputEmail = document.getElementById('email').disabled = false;
        var inputPassword = document.getElementById('password').disabled = false;
        subBtn.disabled = false;
        var email = document.getElementById('email');
        var password = document.getElementById('password');

    });
    
    subBtn.addEventListener('mouseover', function() {

        if (subBtn.disabled == true) {

            subBtn.style.cursor = 'not-allowed';

        } else {

            subBtn.style.cursor = 'pointer';

        }

    });

    inputEmail.addEventListener('mouseover', function() {

        if (inputEmail.disabled == true) {

            inputEmail.style.cursor = 'not-allowed';

        } else {

            inputEmail.style.cursor = 'text';

        }

    });

    inputEmail.addEventListener('change', function() {errorEmail.innerHTML = "";});

    inputPassword.addEventListener('change', function() {errorPassword.innerHTML = "";});

    inputPassword.addEventListener('mouseover', function() {

        if (inputPassword.disabled == true) {

            inputPassword.style.cursor = 'not-allowed';

        } else {

            inputPassword.style.cursor = 'text';

        }

    });

    form.addEventListener('submit', function(e) {
        e.preventDefault();

        if (email.value == "") {

            errorEmail.innerHTML = "Campo obligatorio!";

        }

        if (password.value == "") {

            errorPassword.innerHTML = "Campo obligatorio!";

        }

        if ((userType === 'profesor' || userType === 'padre') && email.value != "" && password.value != "") {

            checkUsers();

        }

    }, false);
}

function returnData() {

    var cad = '';
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;
    cad = 'email='+encodeURIComponent(email)+'&password='+encodeURIComponent(password)+'&userType='+encodeURIComponent(userType);
    return cad;

}

var conection;
function checkUsers() {

    conection = new XMLHttpRequest();
    conection.onreadystatechange = proccessUsers;
    conection.open('POST', 'login.php', true);
    conection.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    conection.send(returnData());

}

var connection_session;
function saveUser() {

    connection_session = new XMLHttpRequest();
    connection_session.onreadystatechange = processUserSave;
    connection_session.open('POST', 'session.php', true);
    connection_session.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    connection_session.send(returnData());

}

function processUserSave() {

    if (connection_session.readyState == 4 && connection_session.status == 200) {

        console.log(connection_session.responseText);

    }

}

function proccessUsers() {

    var error = document.getElementById('errors');

    if (conection.readyState == 4 && conection.status == 200) {

        if (conection.responseText == "pass") {

            saveUser();

            window.location.href = "../Inicio/index.html";

        } else {

            error.innerHTML = conection.responseText;

        }

    }

}