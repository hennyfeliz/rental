export async function localPostData(username, password) {
  const url = "http://localhost:8080/publico/authenticate"; // Reemplaza esto con la URL de tu servidor de inicio de sesión
  const data = {
    username: username,
    password: password,
  };

  return fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      return data;
    })
    .catch((error) => {
      console.error("Error al iniciar sesión:", error);
    });
}
