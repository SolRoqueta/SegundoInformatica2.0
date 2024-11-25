let hasLoaded = false;

let userData;
let userName;
let userMail;

var hasPass = false;

document.addEventListener('DOMContentLoaded', ()=> {

    startEvents();

}, false)

function startEvents() {

    hasLoaded = true;
    getUser(1);

}

var connection_userDB;
function setUser(op, name, mail) {

    connection_userDB = new XMLHttpRequest();
    connection_userDB.open('GET', 'perfil.php?'+dataBaseChooser(op, name, mail), true);
    connection_userDB.send();

}

function dataBaseChooser(op, name, mail) {

    switch (op) {

        case 1:

            return 'option=1&currentName='+userName+'&name='+name;

            break;
        case 2:

            return 'option=2&currentMail='+userMail+'&mail='+mail;

            break;

    }

}

var connection_user;
function getUser(op) {

  connection_user = new XMLHttpRequest();
  connection_user.onreadystatechange = processUser;
  connection_user.open('GET', 'session.php?'+sessionChooser(op), true);
  connection_user.send();

}

function sessionChooser(op) {

    switch (op) {

        case 1:

            return 'option=1';

            break;
        case 2:

            var new_userName = document.getElementById('nameI').value;

            return 'option=2&name='+new_userName;

            break;
        case 3:

            var new_userMail = document.getElementById('emailI').value;

            return 'option=3&mail='+new_userMail;

            break;

    }

}

function processUser() {

    var titleName = document.getElementById('nameTitle');
    var name = document.getElementById('name');
    var email = document.getElementById('email');

    if (connection_user.readyState == 4 && connection_user.status == 200) {

        userData = JSON.parse(connection_user.responseText);

        if (userName != userData[0].nombre) {

            userName = userData[0].nombre;
            titleName.innerHTML = userName;
            cancelName();

        }

        if (userMail != userData[0].mail) {

            userMail = userData[0].mail;
            cancelMail();

        }



        if (!hasPass) {

            name.innerHTML = userName;
            email.innerHTML = userMail;
            hasPass = true;
    
        }

    }

}

function editName() {

    var name_info = document.getElementById('name-info');

    name_info.innerHTML = "";

    var cad = `
            
        <div class="name-div">
            <h6>Nombre</h6>
            <div class="inputs-container">
            
                <input type="text" class="input-field" id="nameI" value="${userName}">

                <div>

                    <button type="button" class="btn save-btn" onclick="saveName()">Guardar</button>
                    <button type="button" class="btn btn-dark cancel-btn" onclick="cancelName()">Cancelar</button>
                
                </div> 
            
            </div>
            
        </div>

    `;

    name_info.innerHTML = cad;

}

function cancelName() {

    var name_info = document.getElementById('name-info');

    var cad = `
    
        <div class="name-div">
            <h6>Nombre</h6>
            <p class="name">${userName}</p>
        </div>

        <button type="button" class="btn btn-dark info-btn" onclick="editName()">Editar</button>
    
    `;

    name_info.innerHTML = cad;

}

function saveName() {

    var name = document.getElementById('nameI').value;

    if (name.length >= 3 && !/\d/.test(name)) {

        setUser(1, name, null);
        getUser(2);
        cancelName();

    } else {

        alert("Nombre no válido");
        document.getElementById('nameI').value = userName;

    }

}

function editMail() {

    var email_info = document.getElementById('email-info');

    email_info.innerHTML = "";

    var cad = `
            
        <div class="email-div">
        
            <h6>Email</h6>
            <div class="inputs-container">
            
                <input type="text" class="input-field" id="emailI" value="${userMail}">

                <div>

                    <button type="button" class="btn save-btn" onclick="saveMail()">Guardar</button>
                    <button type="button" class="btn btn-dark cancel-btn" onclick="cancelMail()">Cancelar</button>
                
                </div> 
            
            </div>
            
        </div>

    `;

    email_info.innerHTML = cad;

}

function cancelMail() {

    var email_info = document.getElementById('email-info');

    email_info.innerHTML = "";

    var cad = `
            
        <div class="email-div">
            <h6>Email</h6>
            <p class="name" id="email">${userMail}</p>
        </div>

        <button type="button" class="btn btn-dark info-btn" onclick="editMail()">Editar</button>

    `;

    email_info.innerHTML = cad;

}

function saveMail() {

    var mail = document.getElementById('emailI').value;

    if (!/\d/.test(mail) && /@/.test(mail)) {

        setUser(2, null, mail);
        getUser(3);

    } else {

        alert("Nombre no válido");
        document.getElementById('emailI').value = userMail;

    }

}