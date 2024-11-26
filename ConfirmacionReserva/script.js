let nombre;
let id;
let precio;

let childsData;

let userData;
var userMail = "";
var userName = "";

function setUserMail(value) {
    userMail = value;
}

function setUserName(value) {
    userName = value;
}

document.addEventListener('DOMContentLoaded', ()=> {

    startEvents();

}, false);

function startEvents() {

    getUser();
    getInfo();
    getChilds(1);
    putFooter();

}

var connection_user;
function getUser() {

  connection_user = new XMLHttpRequest();
  connection_user.onreadystatechange = processUser;
  connection_user.open('GET', 'session.php?option=1', true);
  connection_user.send();

}

var connection_closeUser;
function closeSession(value) {

  connection_closeUser = new XMLHttpRequest();
  connection_closeUser.onreadystatechange = location.reload();
  connection_closeUser.open('GET', 'session.php', true);
  connection_closeUser.send();

}

function processUser() {

  var profile = document.getElementById('profile');
  var dropdown = document.getElementById('profile-dropdown');

  if (connection_user.readyState == 4 && connection_user.status == 200) {

    if (connection_user.responseText != "") {

      userData = JSON.parse(connection_user.responseText);

      setUserName(userData[0].nombre);
      setUserMail(userData[0].mail);

      profile.innerHTML = userName;

      if (userName != null) {

        dropdown.innerHTML = `

          <li><a class="dropdown-item" href="#" onclick="alert('Lleva a la configuracion del usuario')">Perfil</a></li>
          <li><a class="dropdown-item" href="#" onclick="alert('Lleva a los hijos del usuario dentro de la configuracion del mismo')">Hijos</a></li>
          <li><hr class="dropdown-divider"></li> 
          <li><a class="dropdown-item" onclick="closeSession()" href="#">Cerrar sesión</a></li>
                  
        `;

      }

    } else {

        window.location.href = "../Login/login.html";

    }

  }

}

var connection_childs;
function getChilds(value) {

    connection_childs = new XMLHttpRequest();
    connection_childs.onreadystatechange = processChilds;
    connection_childs.open('GET', 'confirmacion.php?'+childSelector(value), true);
    connection_childs.send();

}

function processChilds() {

    if (connection_childs.readyState == 4 && connection_childs.status == 200) {

        const childs_dropdown = document.getElementById('childs-dropdown');
        childs_dropdown.innerHTML = "";

        if (connection_childs.responseText != "[]") {

            childsData = JSON.parse(connection_childs.responseText);

            for (let i = 0; i < childsData.length; i++) {

                var cad = `
                
                    <li><a class="dropdown-item" href="#" onclick="selectChild(${i})">${childsData[i].nombre}</a></li>
                
                `;
    
                childs_dropdown.innerHTML += cad;
    
            }

        } else {

            var cad = `
                
                <li><a class="dropdown-item">No tienes hijos</a></li>
                
            `;
    
            childs_dropdown.innerHTML = cad;

        }

    }

}

function childSelector(op) {

    switch (op) {

        case 1:

            return 'option=1';

        break
        case 2:



        break;

    }

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

function getInfo() {

    const urlParams = new URLSearchParams(window.location.search);
    const datos = JSON.parse(decodeURIComponent(urlParams.get('reserva')));

    if (datos) {

        nombre = datos.nombre;
        id = datos.id;
        precio = datos.precio;
        descripcion = datos.descripcion;

        setValues();

    } else {

        // document.getElementById('info').innerHTML = "Datos no disponibles.";
        getInfo();

    }

}

function setValues() {

    var price = document.getElementById('price');
    price.innerHTML = "Total: $"+precio;

    var menu_name = document.getElementById('menu-name');
    menu_name.innerHTML = nombre;

    var menu_description = document.getElementById('menu-description');
    menu_description.innerHTML = descripcion;

}

function selectChild(id) {

    const child_name = document.getElementById('child-name');
    child_name.innerHTML = "";

    childName = childsData[id].nombre;
    child_name.innerHTML = "Nombre Hijo: " + childName;

}