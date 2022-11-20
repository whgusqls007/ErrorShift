FROM node:16
WORKDIR /var/jenkins_home/workspace/errorshift/fileServer
COPY package*.json /var/jenkins_home/workspace/errorshift/fileServer
RUN npm install
COPY ./ /var/jenkins_home/workspace/errorshift/fileServer
CMD ["npm", "start"]
