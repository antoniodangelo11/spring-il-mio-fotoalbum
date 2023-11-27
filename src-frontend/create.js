const apiMessages = "http://localhost:8080/api/v1/contacts";

// funzione per creare un nuovo messaggio

document
  .getElementById("messageForm")
  .addEventListener("submit", async function (event) {
    event.preventDefault();
    const email = document.getElementById("email").value;
    const message = document.getElementById("message").value;
    try {
      await axios.post(apiMessages, {
        email,
        message,
      });

      // Imposta il messaggio di successo nell'HTML
      successMessage.style.display = "block";
      this.style.display = "none";

      setTimeout(() => {
        window.location.href = "contact.html";
      }, 3000);
    } catch (error) {
      console.error(error);
    }
  });
