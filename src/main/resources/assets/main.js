console.log("Javascript loaded");

setupUserSearch();



// --- Functions --- //
function setupUserSearch() {
    $("button.search").click(function () {
    location.href = '/users?search=' + $("input.search").val();
})
}



