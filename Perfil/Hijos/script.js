let childs;

let userName;
let userMail;
let userData;

document.addEventListener('DOMContentLoaded', () => {

    startEvents();

}, false);

function startEvents() {

    getUser();

    document.querySelector('.dropdown-menu').addEventListener('click', function (e) {

        e.stopPropagation();

    });

    var form = document.getElementById('form');

    form.addEventListener('submit', function (e) {

        e.preventDefault();

        addChild();

    }, true);

}

var connection_user;
function getUser() {

    connection_user = new XMLHttpRequest();
    connection_user.onreadystatechange = processUser;
    connection_user.open('GET', 'session.php?option=1', true);
    connection_user.send();

}

function processUser() {

    if (connection_user.readyState == 4 && connection_user.status == 200) {

        userData = JSON.parse(connection_user.responseText);

        userName = userData[0].nombre;
        userMail = userData[0].mail;

        getChilds();

    }

}

function returnData() {

    let cad = ``;
    let nombre = document.getElementById('name').value;
    nombre = nombre.replace(/\s+/g, "");
    let apellido = document.getElementById('last_name').value;
    apellido = apellido.replace(/\s+/g, "");
    let grupo = document.getElementById('group').value;
    cad = `option=` + encodeURIComponent(2) + `&completeName=` + encodeURIComponent(nombre) + ` ` + encodeURIComponent(apellido) + `&group=` + encodeURIComponent(grupo) + `&mail=` + encodeURIComponent(userMail);
    return cad;

}

var connection_addChild;
function addChild() {

    connection_addChild = new XMLHttpRequest();
    connection_addChild.onreadystatechange = processChild;
    connection_addChild.open('POST', 'hijos.php', true);
    connection_addChild.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    connection_addChild.send(returnData());

}

function processChild() {

    if (connection_addChild.readyState == 4 && connection_addChild.status == 200) {

        var plusDropDown = new bootstrap.Dropdown(document.getElementById('plusDropDown'));
        plusDropDown.hide();

        getChilds();

    }

}

var connection_getChilds;
function getChilds() {

    connection_getChilds = new XMLHttpRequest();
    connection_getChilds.onreadystatechange = processChilds;
    connection_getChilds.open('GET', 'hijos.php?option=1&mail=' + userMail, true);
    connection_getChilds.send();

}

function processChilds() {

    var table = document.getElementById('table');

    if (connection_getChilds.readyState == 4 && connection_getChilds.status == 200) {

        childs = JSON.parse(connection_getChilds.responseText);

        table.innerHTML = "";

        for (var i = 0; i < childs.length; i++) {

            let nombreCompleto = childs[i].nombreCompleto;
            let partes = nombreCompleto.split(" ");

            let nombre = partes[0];
            let apellido = partes[1];
            let grupo = childs[i].grupo;

            var cad = `
            
                <tr>
                    <td>${nombre}</td>
                    <td>${apellido}</td>
                    <td>${grupo}</td>
                </tr>

            `;

            table.innerHTML += cad;

        }

    }

}