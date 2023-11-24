/* COSTANTI*/
const apiUrl = "http://localhost:8080/api/v1/photos";
const root = document.getElementById("root");

/* FUNZIONI */
const renderCategories = (categories) => {
  console.log(categories);
  let content;

  // Aggiungi la verifica se 'categories' è definito
  if (categories && categories.length === 0) {
    content = "No categories";
  } else if (categories) {
    // Aggiungi la verifica se 'categories' è definito
    content = '<ul class="list-unstyled">';
    categories.forEach((cat) => {
      content += `<li>${cat.name}</li>`;
    });
    content += "</ul>";
  } else {
    content = "Categories is undefined";
  }

  return content;
};


const renderPhoto = (element) => {
  console.log(element);
  return `<div class="card shadow h-100">
    <div class="card-body">
      <h5 class="card-title">${element.title}</h5>
      <p class="card-text">${
        element.description != "" ? element.description : "N.D."
      }</p>
      <div>
          <img class="h-100 w-100" src="${element.url}" alt="">
      </div>
    </div>
    <div class="card-footer">${renderCategories(element.categories)}</div>
  </div>`;
};


const renderPhotoList = (data) => {
  let content;
  console.log(data);
  if (data.length > 0) {
    content = '<div class="row">';
    data.forEach((element) => {
      content += '<div class="col-3 mb-4">';
      content += renderPhoto(element);
      content += "</div>";
    });
    content += "</div>";
  } else {
    content = '<div class="alert alert-info">The list is empty</div>';
  }
  root.innerHTML = content;
};


const getPhotos = async () => {
  try {
    const response = await axios.get(apiUrl);
    renderPhotoList(response.data);
  } catch (error) {
    console.log(error);
  }
};

const deletePhoto = async (photoId) => {
  try {
    const response = await fetch(`${apiUrl}/${photoId}`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
        },
    });

    if (!response.ok) {
        throw new Error(`Errore durante la cancellazione della photo con ID ${photoId}`);
    }

    console.log(`Photo con ID ${photoId} eliminata con successo`);
    location.reload();
  } catch (error) {
    console.error(error.message);
}
};

getPhotos();