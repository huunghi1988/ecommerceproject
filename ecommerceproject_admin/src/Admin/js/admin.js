let currentPage = 1;
const usersPerPage = 10; 

function getUsers(page) {
  const xhttp = new XMLHttpRequest();
  const start = (page - 1) * usersPerPage;
  const end = start + usersPerPage;

  xhttp.open("GET", `http://localhost:8080/user?start=${start}&end=${end}`);
  xhttp.send();

  xhttp.onload = function () {
    const userArray = JSON.parse(this.responseText);
    const table = document.querySelector('.grid-container-table table');
    //table.innerHTML = ""; // Clear the table before adding new rows

    userArray.forEach(user => {
      const newRow = document.createElement("tr");
      newRow.setAttribute('data-user-id', user.userId);

      newRow.innerHTML = `
        <td><img src="img/new-product/5-small.jpg" alt="" /></td>
        <td id="username">${user.username}</td>
        <td id="email">${user.email}</td>
        <td id="firstName">${user.firstName}</td>
        <td id="lastName">${user.lastName}</td>
        <td id="Address">${user.address}</td>
        <td>
        <button data-toggle="tooltip" title="Edit" onclick="editUserDetails(${user.userId})" class="pd-setting-ed">
        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
      </button>
          <button data-toggle="tooltip" title="Trash" onclick="deleteUser(${user.userId})" class="pd-setting-ed">
            <i class="fa fa-trash-o" aria-hidden="true"></i>
          </button>
        </td>
        <td>
          <button class="${user.isActive === 1 ? 'pd-setting' : 'ds-setting'}" id="isActive">${user.isActive === 1 ? "Active" : "Disabled"}</button>
        </td>
      `;
      table.appendChild(newRow);
    });

    currentPage = page; // Update the current page
  };
}
function goToPage(page) {
  getUsers(page);
}

function previousPage() {
  if (currentPage > 1) {
    goToPage(currentPage - 1);
  }
}

function nextPage() {
  goToPage(currentPage + 1);
}

window.onload = function () {
  getUsers(currentPage);
};


function deleteUser(userId) {
  const confirmed = confirm("Are you sure you want to delete this user?");

  if (confirmed) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "http://localhost:8080/deleteUser/" + userId);

    xhttp.onload = function () {
      if (xhttp.status === 200) {
        const rowToDelete = document.querySelector(`tr[data-user-id="${userId}"]`);
        if (rowToDelete) {
          rowToDelete.remove();
        }
      } else {
        console.error("Error deleting user.");
      }
    };

    xhttp.send();
  } else {
    console.log("User canceled the deletion.");
  }
};

function editUserDetails(userId) {
  // Redirect the user 
  window.location.href = `file:///Users/nghitran/Downloads/ecommerceproject_admin/src/Admin/user-edit.html?userId=${userId}`;
}

