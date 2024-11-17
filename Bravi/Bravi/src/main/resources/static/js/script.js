const hamBurger = document.querySelector(".toggle-btn");

hamBurger.addEventListener("click", function () {
    document.querySelector("#sidebar").classList.toggle("expand");
});


let popup = document.getElementById('popup')
let overlay = document.getElementById('overlay')

function openPopup(){
    popup.classList.add('open-popup')
    overlay.style.visibility = 'visible';
}

function closePopup(){
    popup.classList.remove('open-popup')
    overlay.style.visibility = 'hidden';
}

let edit_popup = document.getElementById('edit-popup')
let edit_overlay = document.getElementById('edit-overlay')

function openEditPopup(){
    edit_popup.classList.add('open-popup')
    edit_overlay.style.visibility = 'visible';
}

function closeEditPopup(){
    edit_popup.classList.remove('open-popup')
    edit_overlay.style.visibility = 'hidden';
}