document.addEventListener("DOMContentLoaded", function () {
  const searchButton = document.getElementById("searchButton");
  searchButton.addEventListener("click", searchPhotos);
});

function searchPhotos() {
  const searchPhoto = document.getElementById("searchBar").value.toLowerCase();

  console.log("Search button clicked. Searching for:", searchPhoto);

  fetch(`http://localhost:8080/api/v1/photos`)
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to fetch photos");
      }
      return response.json();
    })
    .then((data) => {
      const filteredPhotos = data.filter((photo) =>
        photo.title.toLowerCase().includes(searchPhoto)
      );
      console.log("Filtered photos:", filteredPhotos);
      updatePhotoList(filteredPhotos);
    })
    .catch((error) => {
      console.error("An unexpected error occurred:", error);
    });
}

function updatePhotoList(data) {
  const root = document.getElementById("root");

  if (root) {
    let content = '<div class="row">';
    data.forEach((element) => {
      content += '<div class="col-3 mb-4">';
      content += renderPhoto(element);
      content += "</div>";
    });
    content += "</div>";
    root.innerHTML = content;
  } else {
    console.error("Root element not found");
  }
}