function toggleMenu() {
    const sideMenu = document.getElementById('sideMenu');
    if (sideMenu) {
        sideMenu.classList.toggle('open');
    }
}

document.addEventListener("DOMContentLoaded", function () {
    const carouselWrapper = document.getElementById("carousel-wrapper");
    const carousel = document.getElementById("carousel");
    let currentIndex = 0;
    let visibleItems = window.innerWidth > 768 ? 5 : 3; // 5 imágenes en desktop, 3 en móvil

    const slides = [
        ["/img/cat-1.jpg", "/img/Bird.jpg", "/img/cat2.jpg", "/img/erizo.jpg", "/img/nutria.jpg"],
        ["/img/dog.jpg", "/img/bunny.jpg", "/img/dog2.jpg", "/img/hamsterpose3.jpg", "/img/fox.jpg"],
        ["/img/bunny2.jpg", "/img/funnydogs.jpg", "/img/erizo.jpg", "/img/bird1.jpg", "/img/cat.jpg"]
    ];

    function loadSlide() {
        carousel.innerHTML = ""; // Limpiar carrusel

        slides[currentIndex].forEach((src) => {
            const col = document.createElement("div");
            col.classList.add("carousel-item", "d-flex", "justify-content-center");

            const img = document.createElement("img");
            img.src = src;
            img.classList.add("pinterest-item", "img-fluid", "rounded");
            img.loading = "lazy";

            col.appendChild(img);
            carousel.appendChild(col);
        });

        // Mover el carrusel a la izquierda de forma suave
        carouselWrapper.style.transform = `translateX(-100%)`;

        setTimeout(() => {
            // Después de la transición, reiniciar el carrusel sin que parpadee
            currentIndex = (currentIndex + 1) % slides.length;
            carouselWrapper.style.transition = "none";
            carouselWrapper.style.transform = "translateX(0)";
            loadSlide(); // Cargar nuevas imágenes en el nuevo índice
            setTimeout(() => carouselWrapper.style.transition = "transform 1s ease-in-out", 10);
        }, 2000); // Tiempo de la animación antes de reiniciar
    }

    loadSlide();
    setInterval(loadSlide, 4000); // Cambia cada 4 segundos

    window.addEventListener("resize", function () {
        visibleItems = window.innerWidth > 768 ? 5 : 3;
        currentIndex = 0; // Reiniciar al cambiar tamaño
        loadSlide();
    });

    function openModal(id) {
        const modal = document.getElementById(id);
        if (modal) {
            modal.style.display = "flex";
        } else {
            console.error(`Modal con id '${id}' no encontrado.`);
        }
    }

    function switchToRegister(event) {
        event.preventDefault(); // Evita cualquier recarga o navegación

        closeModal('loginModal'); // Cierra el modal de inicio de sesión
        openModal('registerModal'); // Abre el modal de registro
    }

    function closeModal(id) {
        const modal = document.getElementById(id);
        if (modal) {
            modal.style.display = "none";
        } else {
            console.error(`Modal con id '${id}' no encontrado.`);
        }
    }

    // 🔹 Eventos para abrir los modales
    document.querySelectorAll(".nav-button").forEach(button => {
        button.addEventListener("click", function () {
            if (this.innerText.includes("Iniciar sesión")) openModal("loginModal");
            if (this.innerText.includes("Registrarse")) openModal("registerModal");
        });
    });

    // 🔹 Evento para abrir modal al hacer clic en "Explorar"
    document.querySelector(".explore-button")?.addEventListener("click", function () {
        openModal("loginModal");
    });

    // 🔹 Eventos para cerrar los modales
    document.querySelectorAll(".close-button").forEach(button => {
        button.addEventListener("click", function () {
            const modal = this.closest(".modal-overlay");
            if (modal) closeModal(modal.id);
        });
    });

    // 🔹 Cerrar modal al hacer clic fuera del contenido
    document.querySelectorAll(".modal-overlay").forEach(modal => {
        modal.addEventListener("click", function (event) {
            if (event.target === modal) {
                closeModal(modal.id);
            }
        });
    });

    // 📥 Manejo de formularios con mensajes
    document.querySelector("#loginModal form")?.addEventListener("submit", function (event) {
        event.preventDefault();
        alert(`Iniciando sesión con: ${this.querySelector("input[type=email]").value}`);
        closeModal("loginModal");
    });

    document.querySelector("#registerModal form")?.addEventListener("submit", function (event) {
        event.preventDefault();
        alert(`Registrando usuario: ${this.querySelector("input[type=email]").value}`);
        closeModal("registerModal");
    });

    // 🌟 Animaciones con IntersectionObserver
    const observer = new IntersectionObserver(
        (entries) => {
            entries.forEach((entry) => {
                if (entry.isIntersecting) {
                    entry.target.classList.add("fade-in");
                }
            });
        },
        { threshold: 0.3 }
    );

    document.querySelectorAll(".collection-item").forEach((item) => {
        observer.observe(item);
    });

    function toggleMenu() {
        const sideMenu = document.getElementById('sideMenu');
        if (sideMenu) {
            sideMenu.classList.toggle('open');
        }
    }
});
