'use strict';

let topicForm = document.querySelector('#topicForm');
let topicInput = document.querySelector('#topic')
let messageArea = document.querySelector('#messageArea');
let connectingElement = document.querySelector('.connecting');

let stompClient = null;

function connect() {

    let socket = new SockJS('/ws');

    stompClient = Stomp.over(socket);

    stompClient.connect({}, onConnected, onError);
}

function onConnected() {
    // Get messages from topic subscribed
    stompClient.subscribe('/topic/public', onMessageReceived);

    connectingElement.classList.add('hidden');

}

function onError(error) {
    connectingElement.textContent = 'Could not connect to WebSocket server. Please refresh this page to try again!';
    connectingElement.style.color = 'red';
}

function sendTopic(event) {
    let topic = topicInput.value.trim();
    if (topic && stompClient) {
        let chatDTO = {
            topic: topicInput.value,
            message: '',
        };
        stompClient.send("/app/chat.sendTopic", {}, JSON.stringify(chatDTO));
        topicInput.value = '';
        let messageElement = document.createElement('li');
        messageElement.classList.add('chat-message');
        let textElement = document.createElement('h2');
        let messageText = document.createTextNode("Joined to Topic: " + topic);
        textElement.appendChild(messageText);
        messageElement.appendChild(textElement);
        messageArea.appendChild(messageElement);
    }
    topicForm.classList.add('hidden');
    event.preventDefault();
}

function onMessageReceived(payload) {
    let chatDTO = JSON.parse(payload.body);

    chatDTO.forEach(chat => {
        let messageElement = document.createElement('li');
        messageElement.classList.add('chat-message');
        let textElement = document.createElement('p');
        let messageText = document.createTextNode(chat.message);
        textElement.appendChild(messageText);
        messageElement.appendChild(textElement);
        messageArea.appendChild(messageElement);
    });

    messageArea.scrollTop = messageArea.scrollHeight;
}

topicForm.addEventListener('submit', sendTopic, true)