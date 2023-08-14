window.onload = function () {
  // Get the userId from the URL query parameters (e.g., )
  const urlParams = new URLSearchParams(window.location.search);
  const userId = urlParams.get("userId");

  getUser(userId);
};


function getUser(userId) {
    const xhttp = new XMLHttpRequest();
    xhttp.open("GET", "http://localhost:8080/userDetail/" + userId);
    xhttp.send();
  
    xhttp.onload = function () {
      const user = JSON.parse(this.responseText);
  
      // Populate the user details in the user-edit.html page
      document.getElementById("userName").value = user.username=== undefined ? "" : user.username;
      document.getElementById("email").value = user.email=== undefined ? "" : user.email;
      document.getElementById("lastName").value = user.lastName=== undefined ? "" : user.lastName;
      document.getElementById("firstName").value= user.firstName=== undefined ? "" : user.firstName;
      document.getElementById("address").value = user.address=== undefined ? "" : user.address;
      document.getElementById("suburb").value = user.suburb=== undefined ? "" : user.suburb;
      document.getElementById("state").value = user.state=== undefined ? "" : user.state;
      document.getElementById("postcode").value= user.postcode=== undefined ? "" : user.postcode;
      document.getElementById("phoneNumber").value= user.phoneNumber=== undefined ? "" : user.phoneNumber;
      document.getElementById("isActive").value = user.isActive;
    };
  }           
  
 

  function updateUser() {
    const FD = new FormData();

    // Push our data into our FormData object
    for (const [name, value] of Object.entries(data)) {
      FD.append(name, value);
    }
  
    // Define what happens on successful data submission
    XHR.addEventListener("load", (event) => {
      alert("Yeah! Data sent and response loaded.");
    });
  
    // Define what happens in case of an error
    XHR.addEventListener("error", (event) => {
      alert("Oops! Something went wrong.");
    });
  
    // Set up our request
    XHR.open("POST", "https://example.com/cors.php");
  
    // Send our FormData object; HTTP headers are set automatically
    XHR.send(FD);
  }
  
  btn.addEventListener("click", () => {
    sendData({ test: "ok" });
  });
  }           
  
  window.onload = function () {
    // Get the userId from the URL query parameters (e.g., )
    const urlParams = new URLSearchParams(window.location.search);
    const userId = urlParams.get("userId");
  
    getUserDetail(userId);
  };