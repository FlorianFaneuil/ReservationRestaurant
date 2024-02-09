
document.addEventListener("DOMContentLoaded", function() {
   
    var currentPageLink = document.querySelector('a[href="' + window.location.pathname + '"]');

   
    if (currentPageLink) {
        currentPageLink.classList.add('active');
    }
});

function toggleMenu() {
    var menu = document.getElementById("menub");
    menu.classList.toggle("show-menu");
}


