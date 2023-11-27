const apiUrl = "http://localhost:8080/api/v1/photos";
const root = document.getElementById("root");

//Inizializzo la card
const cardPhoto = (element) => {

  console.log(element);
  return `<div class="card bg-dark text-light border-2                  border-secondary h-100">
        <img src=${
          element.url
        } class="card-img-top object-fit-cover" alt="..." style="height: 300px;">
        <div class="card-body">
            <h5 class="card-title">${element.title}</h5>
            <p class="card-text">${element.description}</p>
        </div>
        <div class="list-group list-group-flush">
            <div class="list-group-item bg-dark text-light border-secondary">
                <span class="fw-semibold text-info"> 
                    Category 
                </span>
                <span>
                    ${renderCategories(element.categories)}
                </span>
            </div>
        </div>
    </div>`;
};

//Inizializzo la lista delle card
const photoList = (data) => {
  let content;
  console.log(data);
  // condizioni
  if (data.length > 0) {
    content = '<div class="row">';

    data.forEach((element) => {
      content += '<div class="col-3 mb-4">';
      content += cardPhoto(element);
      content += "</div>";
    });
  } else {
    content = '<div class="alert alert-info">The list is empty</div>';
  }
  // sostituisco il contenuto di root con il mio content
  root.innerHTML = content;
};

// funzione che chiama l'api e ottiene il json con l'array di pizzas

const getPhoto = async () => {
  try {
    const response = await axios.get(apiUrl);
    photoList(response.data);
  } catch (error) {
    console.log(error);
  }
};

// funzione che renderizza le categorie del book
const renderCategories = (categories) => {
  console.log(categories);
  let content;
  if (categories.length === 0) {
    content = "No categories";
  } else {
    content = '<ul class="list-unstyled">';
    categories.forEach((cat) => {
      content += `<li>${cat.name}</li>`;
    });
    content += "</ul>";
  }
  return content;
};

getPhoto();