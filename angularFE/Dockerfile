# Step 1: Build the Angular application
FROM node:18 as build

# Imposta la directory di lavoro
WORKDIR /webappFE

# Copia il package.json e installa le dipendenze
COPY package*.json ./
RUN npm install

# Copia il codice sorgente dell'app e builda l'app Angular
COPY . .
RUN npm install -g @angular/cli
RUN npm run build --prod



# Step 2: Serve l'app con un web server (Nginx)
FROM nginx:alpine

# Copia i file buildati dal passaggio precedente nella cartella Nginx per il deploy
COPY --from=build /webappFE/dist/angular-fe /usr/share/nginx/html

# Espone la porta 80 per Nginx
EXPOSE 80

# Comando di default per Nginx
CMD ["nginx", "-g", "daemon off;"]
