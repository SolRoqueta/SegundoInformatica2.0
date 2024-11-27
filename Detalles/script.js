let tipo;
let id;
let tipoId;
var cad;

let userData;
let userName;
let userMail;

let data;

document.addEventListener('DOMContentLoaded', function () {

    startEvents();

}, false);

function startEvents() {

    getUser();
    putFooter();

}

function putFooter() {

    const footerContainer = document.getElementById('footer-container');

    // Usa fetch para cargar el archivo footer.html
    fetch('../footer/footer.html')

        .then(response => {

            if (!response.ok) {

                throw new Error('Error al cargar el footer');

            }

            return response.text();

        })
        .then(footer => {

            footerContainer.innerHTML = footer;

        })
        .catch(error => {

            console.error('Error:', error);

        });

}

var connection_user;
function getUser() {

    connection_user = new XMLHttpRequest();
    connection_user.onreadystatechange = processUser;
    connection_user.open('GET', 'session.php?option=1', true);
    connection_user.send();

}

var connection_closeUser;
function closeSession() {

    connection_closeUser = new XMLHttpRequest();
    connection_closeUser.onreadystatechange = location.reload();
    connection_closeUser.open('GET', 'session.php?option=2', true);
    connection_closeUser.send();

}

function processUser() {

    var profile = document.getElementById('profile');
    var dropdown = document.getElementById('profile-dropdown');

    if (connection_user.readyState == 4 && connection_user.status == 200) {

        if (connection_user.responseText != "") {

            userData = JSON.parse(connection_user.responseText);

            console.log("Nombre del usuario: " + userData[0].nombre);

            userName = userData[0].nombre;
            userMail = userData[0].mail;

            profile.innerHTML = userName;

            if (userName != "") {

                dropdown.innerHTML = `

                    <li><a class="dropdown-item" href="../Perfil/Perfil_Usuario/perfil.html">Perfil</a></li>
                    <li><a class="dropdown-item" href="../Perfil/Hijos/hijos.html">Hijos</a></li>
                    <li><hr class="dropdown-divider"></li> 
                    <li><a class="dropdown-item" onclick="closeSession()" href="#">Cerrar sesión</a></li>
                            
                `;

            }

        } else {

            dropdown.classList.remove("dropdown-menu");
            profile.addEventListener('click', (e) => {

                e.preventDefault();
                window.location.href = "../Login/login.html"

            }, true);

            userName = null;
            userMail = null;
            userData = null;

        }

        getInfo();

    }

}

function getInfo() {

    const urlParams = new URLSearchParams(window.location.search);
    const datos = JSON.parse(decodeURIComponent(urlParams.get('datos')));

    if (datos) {

        console.log("Si pasó");

        tipo = datos.tipo;
        id = datos.id;
        tipoId = datos.tipoId;
        getItem();

    } else {

        console.log("No paso");

        // document.getElementById('info').innerHTML = "Datos no disponibles.";
        getInfo();

    }

}

function returnData() {

    var cad = '';
    cad = 'tipo=' + tipo + '&id=' + id + '&tipoId=' + tipoId;
    return cad;

}

function getUserName() {
    return userName;
}

var item_connection;
function getItem() {

    item_connection = new XMLHttpRequest();
    item_connection.onreadystatechange = processItem;
    item_connection.open('POST', 'detalles.php', true);
    item_connection.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    item_connection.send(returnData());

}

function processItem() {

    var resultado = document.getElementById('resultado');
    resultado.innerHTML = "";

    if (item_connection.readyState == 4 && item_connection.status == 200) {

        data = JSON.parse(item_connection.responseText);

        if (tipo == "productos" || userName == null) {

            console.log("productos");

            cad = `

                <div class="content">
        
                    <div class="image-div">
                        <img src="${data[0].foto}" alt="" class="item-img">
                    </div>

                    <div class="item-info">
                    <h1 class="item-title">${data[0].nombre}</h1>
                    <p class="item-description" lang="es">${data[0].descripcion}</p>
                    <h3 class="item-price">$${data[0].precio}</h3>
             
                    </div>

                </div>

            `;

        }

        if (tipo == "menus" && userName != null) {

            console.log("menus");

            cad = `

                <div class="content">
        
                    <div class="image-div">
                        <img src="${data[0].foto}" alt="" class="item-img">
                    </div>

                    <div class="item-info">
                    <h1 class="item-title">${data[0].nombre}</h1>
                    <p class="item-description" lang="es">${data[0].descripcion}</p>
                    <h3 class="item-price">$${data[0].precio}</h3>

                    <button type="button" class="btn btn-dark order-button" onclick="grabAndSendData(${0})">Reservar</button>
                    </div>

                </div>

            `;

        }

        resultado.innerHTML = cad;

    }

}

function grabAndSendData(id) {

    if (data[id]) {
        const datos = { nombre: data[id].nombre, id: data[id].id, precio: data[id].precio, descripcion: data[id].descripcion };
        const datosJSON = encodeURIComponent(JSON.stringify(datos));
        window.location.href = `../ConfirmacionReserva/confirmacion.html?reserva=${datosJSON}`;
    } else {
        console.log("No hay datos para este ID");
    }

}