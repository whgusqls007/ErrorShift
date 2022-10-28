FROM node:16.17.1-alpine
WORKDIR /var/jenkins_home/workspace/errorshift/frontend
COPY package*.json /var/jenkins_home/workspace/errorshift/frontend/
RUN npm install
COPY ./ /var/jenkins_home/workspace/errorshift/frontend/
RUN npm run build
RUN npm install -g serve
ENTRYPOINT ["serve", "-s", "build"]

