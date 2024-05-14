
var role = localStorage.getItem('role');
var roleHidden = document.querySelectorAll('.role');

function setRole(value) {
    role = value;
    localStorage.setItem('role', role);
    updateRole();
}

document.addEventListener('DOMContentLoaded', function () {

    updateRole();
});

function updateRole() {
    role = localStorage.getItem('role');
    if (role === 'false') {
        roleHidden.forEach((el)=>{
            el.style.display = 'block';
        });
    } else {
        roleHidden.forEach((el)=>{
            el.style.display = 'none';
        });
    }
}