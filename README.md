# Coffee Break

## Základní informace

Coffee Break je full-stack projekt zaměřený na správu nabídky kavárny a práci s objednávkami. Aplikace je rozdělena na frontendovou a backendovou část, které spolu komunikují prostřednictvím REST API.

Projekt slouží jako ukázka propojení moderního webového frontendu postaveného na Reactu se serverovou částí vytvořenou ve Spring Bootu. Součástí řešení je práce s entitami, CRUD operacemi, routováním, správou stavu aplikace a nasazením do cloudu.

## Odkazy na nasazenou aplikaci

- Frontend: https://czu-coffee-break.netlify.app/
- Backend: https://coffee-break-1.onrender.com
- Swagger UI: https://coffee-break-1.onrender.com/swagger-ui/index.html

## Upozornění k provozu

Backend je nasazen na platformě Render ve free tarifu. Z tohoto důvodu bývá služba po delší neaktivitě uspána. Při prvním požadavku je proto nutné počítat s delší dobou odezvy, která může být přibližně až 50 sekund.

Při demonstraci projektu je doporučeno nejprve otevřít backend nebo Swagger UI a vyčkat na probuzení služby.

## Cíl projektu

Cílem projektu bylo vytvořit jednoduchou webovou aplikaci pro prostředí kavárny, která umožní:

- zobrazit nabídku káv,
- zobrazit seznam poboček,
- pracovat s košíkem objednávky,
- zobrazovat objednávky zákazníka,
- spravovat nabídku a pobočky z pohledu zaměstnance,
- poskytovat backendové REST API pro práci s daty.

## Použité technologie

### Frontend

- React 19
- TypeScript
- Vite
- TanStack Router
- TanStack Query
- Axios
- React Bootstrap
- Zustand

### Backend

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Spring Validation
- springdoc OpenAPI / Swagger UI
- Spring Boot Actuator
- H2 Database
- Maven

## Struktura projektu

Repozitář obsahuje obě části aplikace:

- `frontend/` - frontendová část aplikace
- `src/main/java/` - backendová část aplikace
- `src/main/resources/` - konfigurační soubory backendu
- `src/test/java/` - testy backendu
- `Dockerfile` - kontejnerizace backendu

## Popis funkcionality

### Veřejná a zákaznická část

Aplikace umožňuje uživateli:

- prohlížet nabídku nápojů,
- zobrazit seznam kaváren,
- přidávat položky do košíku,
- přejít na přehled objednávek.

### Zaměstnanecká část

Zaměstnanec má k dispozici:

- správu nabídky nápojů,
- správu poboček,
- přehled objednávek podle vybrané pobočky.

### Backendové entity

Backend pracuje zejména s těmito entitami:

- `AppUser`
- `Cafe`
- `Coffee`
- `CoffeeOrder`
- `OrderItem`

## REST API

Backend poskytuje standardní CRUD endpointy pro hlavní entity:

- `/user`
- `/cafe`
- `/coffee`
- `/order`
- `/orderItem`

Kromě základních CRUD operací obsahuje i specializované endpointy:

- `GET /user/{userId}/order` - načtení objednávek konkrétního uživatele
- `POST /order/{id}/status?newState=...` - změna stavu objednávky

Podporované stavy objednávky:

- `NEW`
- `IN_PROGRESS`
- `READY_TO_PICKUP`
- `COMPLETED`
- `DECLINED`
- `UNCLAIMED`

Kompletní přehled endpointů a jejich struktury je k dispozici ve Swagger UI.

## Lokální spuštění projektu

### Backend

Požadavky:

- Java 17 nebo novější
- Maven nebo Maven Wrapper

Spuštění:

```powershell
.\mvnw.cmd spring-boot:run
```

Build:

```powershell
.\mvnw.cmd clean package
```

Lokální adresa backendu:

- `http://localhost:8080`

Další dostupné nástroje:

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- H2 Console: `http://localhost:8080/h2-console`

Výchozí databázová konfigurace:

- JDBC URL: `jdbc:h2:mem:testdb`
- uživatel: `sa`
- heslo: `password`

### Frontend

Požadavky:

- Node.js
- Yarn

Spuštění:

```powershell
cd frontend
yarn install
yarn dev
```

Lokální adresa frontendu:

- `http://localhost:5173`

Doporučené proměnné prostředí pro frontend:

```env
VITE_API_BASE_URL=http://localhost:8080
VITE_BASE_URL=/
VITE_FRONTEND_ONLY=false
```

## Docker

Backend lze spustit také pomocí Dockeru:

```powershell
docker build --tag coffee-break-backend .
docker run -p 8887:8080 coffee-break-backend:latest
```

## Inicializační data

Při prvním spuštění backend naplní databázi ukázkovými daty.

### Ukázkové uživatelé

- `alice@gmailx.com` / `pass`
- `bob@gmailx.com` / `pass`
- `charlie@gmailx.com` / `pass`
- `diana@gmailx.com` / `pass`
- `eve@gmailx.com` / `pass`

### Ukázkové kavárny

- Kavárna PEF
- Kavárna TF
- Kavárna Centrum

### Ukázkové položky nabídky

- Espresso
- Cappuccino
- Latte

## Stav implementace

Projekt je funkční aplikace. Backend poskytuje CRUD API, testovanou datovou vrstvu a základní monitorovací podporu přes Spring Boot Actuator. Frontend obsahuje veřejnou, zákaznickou i zaměstnaneckou část aplikace.

Zároveň je potřeba uvést, že některé části jsou v současné podobě řešeny jednodušeji:

- přihlášení ve frontendu je momentálně mockované,
- registrace není plně napojena na backend,
- potvrzení objednávky v košíku je ve frontendu zatím simulované,
- backend používá ve výchozím nastavení in-memory databázi H2, takže po restartu aplikace dochází ke ztrátě dat.

## Testování

Bylo ověřeno spuštění backend testů příkazem:

```powershell
.\mvnw.cmd test
```

Výsledek ověření dne `2026-04-19`:

- 9 testů prošlo úspěšně
- 0 chyb
- 0 selhání

Testy pokrývají především repository vrstvu:

- `CafeRepositoryTest`
- `CoffeeRepositoryTest`
- `OrderItemRepositoryTest`
- `OrderRepositoryTest`
- `UserRepositoryTest`

Frontend build nebylo možné v aktuálním prostředí ověřit, protože zde nebyl dostupný `node`, `npm` ani `yarn`.

## Závěr

Projekt Coffee Break představuje webovou aplikaci pro správu kavárenského provozu s oddělenou klientskou a serverovou vrstvou. Hlavním přínosem projektu je propojení React frontendu se Spring Boot backendem, návrh REST API a praktické ověření principů full-stack vývoje. Současně ponechává prostor pro další rozšíření, zejména v oblasti autentizace, práce s objednávkami a trvalého ukládání dat.
