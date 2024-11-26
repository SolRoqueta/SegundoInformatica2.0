let nombre;
let id;
let precio;

let childsData;

let userData;
var userMail = "";
var userName = "";

let date;

let hasEnabled = false;

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
    getCurrentDateAndHour();
    getChilds(1);
    putFooter();

}

function getCurrentDateAndHour() {

    const hour_and_date = document.getElementById('hour-and-date');
    hour_and_date.innerHTML = "";

    const fechaActual = new Date();

    date = fechaActual.toLocaleDateString();

    const horaSinSegundos = fechaActual.toLocaleTimeString('es-ES', { 

        hour: '2-digit', 
        minute: '2-digit' 

    });

    hour_and_date.innerHTML = date + " " + horaSinSegundos;

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
  connection_closeUser.open('GET', 'session.phpoption=2', true);
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

        // dropdown.innerHTML = `

        //   <li><a class="dropdown-item" href="../Perfil/Perfil_Usuario/perfil.html">Perfil</a></li>
        //   <li><a class="dropdown-item" href="../Perfil/Hijos/hijos.html">Hijos</a></li>
        //   <li><hr class="dropdown-divider"></li> 
        //   <li><a class="dropdown-item" onclick="closeSession()" href="#">Cerrar sesión</a></li>
                  
        // `;

        dropdown.classList.remove("dropdown-menu");
        profile.classList.remove("dropdown-toggle");

      }

    } else {

        window.location.href = "../Login/login.html";

    }

  }

}

function getUserName() {

    return userName;

}

var connection_childs;
function getChilds(value) {

    connection_childs = new XMLHttpRequest();
    connection_childs.onreadystatechange = processChilds;
    connection_childs.open('GET', 'confirmacion.php?'+childSelector(value, date, precio), true);
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

function childSelector(op, precio) {

    switch (op) {

        case 1:

            return 'option=1';

        break
        case 2:

            const fechaActual = new Date();

            const anio = fechaActual.getFullYear();
            const mes = String(fechaActual.getMonth() + 1).padStart(2, '0'); // Meses van de 0 a 11
            const dia = String(fechaActual.getDate()).padStart(2, '0');
            
            const fechaFormateada = `${anio}-${mes}-${dia}`;

            return 'option=2&date='+encodeURIComponent(fechaFormateada)+'&total='+encodeURIComponent(precio);

        break;
        case 3:

            return 'option=3';

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

    const child_dropdown_text = document.getElementById('child-dropdown-text');
    child_dropdown_text.innerHTML = childName;

    enableOrderBtn();

}

function enableOrderBtn() {

    const acceptOrderBtn = document.getElementById('acceptOrderBtn');
    acceptOrderBtn.classList.remove("disabled");
    hasEnabled = true;

}

function confirmOrder() {

    getChilds2(2);
    getChilds3();

}

var connection_childs2;
function getChilds2(value) {

    connection_childs2 = new XMLHttpRequest();
    connection_childs2.onreadystatechange = processChilds2;
    connection_childs2.open('GET', 'confirmacion.php?'+childSelector(value, precio), true);
    connection_childs2.send();

}

function processChilds2() {

    const result = document.getElementById('result');

    if (connection_childs2.readyState == 4 && connection_childs2.status == 200) {

        result.innerHTML = "Reserva realizada con exito!";

    }

}

var connection_childs3;
function getChilds3() {

    connection_childs3 = new XMLHttpRequest();
    connection_childs3.onreadystatechange = alert(connection_childs3.responseText);
    connection_childs3.open('GET', 'confirmacion.php?'+childSelector(3, null), true);
    connection_childs3.send();

}