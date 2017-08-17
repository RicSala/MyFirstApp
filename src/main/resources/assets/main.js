console.log("Javascript loaded");

setupUserSearch();



// --- Functions --- //
function setupUserSearch() {
    $("button.search").click(function () {
    alert("estoy aquí!");
    location.href = '/users?search=' + $("input.search").val();
})
}



