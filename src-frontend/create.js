document
.getElementById("photo-create")
.addEventListener("submit", async function (event) {
event.preventDefault();

try {
    // Ottenere i dati del modulo
    var formData = new FormData(event.target);

    // Effettuare la richiesta API
    const response = await fetch("http://localhost:8080/api/v1/photos", {
    method: "POST",
    headers: {
        "Content-Type": "application/json",
    },
    body: JSON.stringify({
        name: formData.get("title"),
        url: formData.get("url"),
        description: formData.get("description"),
    }),
    });

    if (!response.ok) {
    throw new Error("Failed to create photo");
    }

    const data = await response.json();
    console.log("Photo created successfully:", data);

    // Ridireziona alla pagina principale
    window.location.href = "/";
} catch (error) {
    console.error("An unexpected error occurred:", error);
}
});
