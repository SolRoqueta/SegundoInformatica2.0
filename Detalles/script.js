let tipo;
let id;
let tipoId;
var cad;

document.addEventListener('DOMContentLoaded', function() {

    startEvents();

}, false);

function startEvents() {

    getUser();
    getInfo();
    putFooter();

}

function putFooter() {

    const footerContainer = document.getElementById('footer-container');

    // Usa fetch para cargar el archivo footer.html
    fetch('footer.html')

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

          <li><a class="dropdown-item" href="#" onclick="alert('Lleva a la configuracion del usuario')">Perfil</a></li>
          <li><a class="dropdown-item" href="#" onclick="alert('Lleva a los hijos del usuario dentro de la configuracion del mismo')">Hijos</a></li>
          <li><hr class="dropdown-divider"></li> 
          <li><a class="dropdown-item" onclick="closeSession()" href="#">Cerrar sesión</a></li>
                  
        `;

      }

    } else {

      dropdown.innerHTML = `

          <li><a class="dropdown-item" href="../Login/login.html">Iniciar sesión</a></li>
                  
        `;

    }

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

        var data = JSON.parse(item_connection.responseText);

        if (tipo == "productos") {

            cad = `

                <div class="content">
        
                    <div class="image-div">
                        <img src="../img/ejemplo.PNG" alt="" class="item-img">
                    </div>

                    <div class="item-info">
                    <h1 class="item-title">${data[0].nombre}</h1>
                    <h3 class="item-price">$${data[0].precio}</h3>
                    <p class="item-description">${data[0].descripcion}</p>

                    </div>

                </div>

            `;

        }
        
        if (tipo == "menus") {

            cad = `

                <div class="content">
        
                    <div class="image-div">
                        <img src="../img/ejemplo.PNG" alt="" class="item-img">
                    </div>

                    <div class="item-info">
                    <h1 class="item-title">${data[0].nombre}</h1>
                    <h3 class="item-price">$${data[0].precio}</h3>
                    <p class="item-description">${data[0].descripcion}</p>

                    <button type="button" class="btn btn-dark order-button">Reservar</button>
                    </div>

                </div>

            `;

        }

        resultado.innerHTML = cad;

    }

}