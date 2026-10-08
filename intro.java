import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Intro {
    private static final String HTML = """
            <!DOCTYPE html>
            <html lang="es">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Rojo Vino - Juegos AAA</title>
                <style>
                    * { box-sizing: border-box; }

                    body {
                        min-height: 100vh;
                        margin: 0;
                        background:
                            radial-gradient(circle at center, rgba(255, 255, 255, 0.06), transparent 35%),
                            linear-gradient(135deg, #5a0c18 10%, #2b050b 90%);
                        color: white;
                        font-family: Arial, sans-serif;
                    }

                    .container {
                        width: 94%;
                        max-width: 1100px;
                        margin: 4vh auto 6vh;
                        text-align: center;
                    }

                    h1 {
                        margin: 0 0 0.5rem 0;
                        font-size: clamp(2rem, 6.5vw, 3.75rem);
                        text-shadow: 0 2px 12px rgba(0, 0, 0, 0.6);
                        letter-spacing: 0.03em;
                    }

                    p.intro {
                        margin: 0 0 1.5rem 0;
                        font-size: clamp(0.95rem, 2.6vw, 1.15rem);
                        opacity: 0.95;
                    }

                    section.game {
                        background: rgba(0,0,0,0.12);
                        border-radius: 10px;
                        padding: 1rem 1.15rem;
                        margin: 1rem 0;
                        text-align: left;
                    }

                    section.game h2 {
                        margin: 0 0 0.35rem 0;
                        font-size: 1.15rem;
                    }

                    section.game p { margin: 0.25rem 0; }

                    section.game ul { margin: 0.35rem 0 0.25rem 1rem; }

                    @media (min-width: 900px) {
                        .container { margin-top: 6vh; }
                        section.game { padding: 1.25rem 1.5rem; }
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1 id="titulo">JUEGOS AAA MÁS ESPERADOS</h1>
                    <p class="intro">Estos son algunos de los juegos más esperados por la comunidad gaming, tanto en consolas como en PC.</p>

                    <section class="game">
                        <h2>GRAND THEFT AUTO VI (Rockstar Games)</h2>
                        <p><strong>Fecha de lanzamiento:</strong> 19 de noviembre de 2026 &nbsp; <strong>Plataformas:</strong> PlayStation 5, Xbox Series X/S</p>
                        <p><strong>Resumen del proyecto:</strong> Es la entrega más ambiciosa en la historia de Rockstar Games. Ambientado en el estado ficticio de Leonida (basado en Florida) con Vice City como núcleo urbano, introduce por primera vez un sistema de dos protagonistas colaborativos: Jason y Lucia.</p>
                        <p><strong>Avances técnicos y mecánicas de juego:</strong></p>
                        <ul>
                            <li>Motor de renderizado RAGE evolucionado: incorpora simulaciones físicas avanzadas para la interacción con el agua, el oleaje marítimo y la densidad de las multitudes en playas, calles y discotecas.</li>
                            <li>Redes sociales e inteligencia artificial: los NPCs reaccionan de forma orgánica a los eventos en tiempo real. Las redes sociales internas del juego funcionan como mecanismo dinámico para obtener pistas sobre misiones, carreras ilegales y eventos aleatorios dentro del mapa.</li>
                            <li>Físicas de vehículos y destrucción: física de conducción rediseñada para ofrecer una respuesta más pesada y realista, junto con un sistema de daños estructurales detallado para automóviles, embarcaciones y aeronaves.</li>
                        </ul>
                    </section>

                    <section class="game">
                        <h2>TOMB RAIDER: LEGACY OF ATLANTIS (Crystal Dynamics / Amazon Games)</h2>
                        <p><strong>Fecha de lanzamiento:</strong> 12 de febrero de 2027 &nbsp; <strong>Plataformas:</strong> PC, PlayStation 5, Xbox Series X/S</p>
                        <p><strong>Resumen del proyecto:</strong> Desarrollado sobre Unreal Engine 5, esta entrega busca unificar la faceta de aventurera experimentada de Lara Croft con la jugabilidad táctica de la trilogía más reciente.</p>
                        <p><strong>Avances técnicos y mecánicas de juego:</strong></p>
                        <ul>
                            <li>Iluminación y destrucción contextual: gracias a Nanite y Lumen, el entorno reacciona al fuego, explosiones y acertijos; las estructuras antiguas pueden colapsar progresivamente si no se resuelven correctamente.</li>
                            <li>Exploración no lineal: zonas masivas en biomas selváticos y subterráneos; gancho dinámico, equipo de escalada técnica y herramientas de mapeo para trazar rutas propias.</li>
                            <li>Combate ágil y sigilo: rediseño del sistema de combate cuerpo a cuerpo y a distancia, permitiendo encadenar ejecuciones sigilosas con armas improvisadas y trampas ambientales.</li>
                        </ul>
                    </section>

                    <section class="game">
                        <h2>FABLE (Playground Games / Xbox Game Studios)</h2>
                        <p><strong>Fecha de lanzamiento:</strong> 23 de febrero de 2027 &nbsp; <strong>Plataformas:</strong> PC, PlayStation 5, Xbox Series X/S (Disponible de lanzamiento en Xbox Game Pass)</p>
                        <p><strong>Resumen del proyecto:</strong> Un reinicio completo de la mítica franquicia RPG de acción. Mantiene el tono irónico y el humor negro británico característico.</p>
                        <p><strong>Avances técnicos y mecánicas de juego:</strong></p>
                        <ul>
                            <li>Motor ForzaTech adaptable: gestión de biomas con vegetación densa, simulación de barro y partículas de magia en Albion.</li>
                            <li>Sistema de moralidad y repercusiones socioeconómicas: cada decisión altera el aspecto del personaje, la actitud de los habitantes y la economía local.</li>
                            <li>Combate fluido multifacético: alternancia instantánea entre espadas, arcos/ballestas y canalización de hechizos elementales.</li>
                        </ul>
                    </section>

                    <section class="game">
                        <h2>EXODUS (Archetype Entertainment)</h2>
                        <p><strong>Fecha de lanzamiento:</strong> 7 de abril de 2027 &nbsp; <strong>Plataformas:</strong> PC, PlayStation 5, Xbox Series X/S</p>
                        <p><strong>Resumen del proyecto:</strong> RPG de acción y ciencia ficción espacial liderado por veteranos (ex-BioWare). La premisa gira en torno a la lucha de la humanidad por sobrevivir en un cúmulo galáctico hostil.</p>
                        <p><strong>Avances técnicos y mecánicas de juego:</strong></p>
                        <ul>
                            <li>Dilatación temporal interactiva: viajes a altas velocidades afectan el paso del tiempo entre el jugador y su base, con consecuencias para generaciones futuras.</li>
                            <li>Compañeros y árbol de relaciones: sistema profundo donde aliados pueden envejecer, morir o cambiar de bando por los saltos temporales.</li>
                            <li>Combate con armamento alienígena: tercera persona con cobertura táctica, exoesqueletos con habilidades gravitatorias y gestión de recursos tecnológicos extraterrestres.</li>
                        </ul>
                    </section>

                </div>
            </body>
            </html>
            """;

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", Intro::handleRequest);
        server.start();
        System.out.println("Página disponible en http://localhost:8080/");
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {
        byte[] content = HTML.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(200, content.length);
        exchange.getResponseBody().write(content);
        exchange.close();
    }
}