document.querySelector('.chat-input button').addEventListener('click', function() {
    const input = document.querySelector('.chat-input input');
    const messageText = input.value;
    
    if (messageText.trim() !== "") {
        const message = document.createElement('div');
        message.classList.add('message', 'sent');
        message.innerHTML = `<p>${messageText}</p><span>오후 5:50</span>`;
        document.querySelector('.chat-messages').appendChild(message);
        input.value = "";
    }
});
