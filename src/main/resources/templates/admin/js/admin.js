const users = [];
for (let i = 1; i <= 100; i++) {
    users.push({
        id: `user${i}@example.com`,
        name: `User ${i}`,
        role: 'user',
        locked: 'N',
        reports: 0,
        penalty: (Math.random() * 10).toFixed(1),
        loginAttempts: Math.floor(Math.random() * 10),
        joinDate: `2024.${String(Math.floor(Math.random() * 12) + 1).padStart(2, '0')}.${String(Math.floor(Math.random() * 28) + 1).padStart(2, '0')}`
    });
}

const rowsPerPage = 20;
let currentPage = 1;

function renderTable() {
    const tbody = document.getElementById('userTableBody');
    tbody.innerHTML = '';

    const start = (currentPage - 1) * rowsPerPage;
    const end = start + rowsPerPage;
    const paginatedUsers = users.slice(start, end);

    paginatedUsers.forEach(user => {
        const row = document.createElement('tr');
        Object.values(user).forEach(value => {
            const cell = document.createElement('td');
            cell.textContent = value;
            row.appendChild(cell);
        });
        const manageCell = document.createElement('td');
        const manageButton = document.createElement('button');
        manageButton.textContent = '관리';
        manageButton.className = 'manage';
        manageCell.appendChild(manageButton);
        row.appendChild(manageCell);
        tbody.appendChild(row);
    });

    renderPagination();
}

function renderPagination() {
    const pageNumbers = document.getElementById('pageNumbers');
    pageNumbers.innerHTML = '';

    const totalPages = Math.ceil(users.length / rowsPerPage);
    let startPage = currentPage - 2;
    let endPage = currentPage + 1;

    if (startPage < 1) {
        startPage = 1;
        endPage = Math.min(4, totalPages);
    } else if (endPage > totalPages) {
        endPage = totalPages;
        startPage = Math.max(1, endPage - 3);
    }

    for (let i = startPage; i <= endPage; i++) {
        const pageNumber = document.createElement('span');
        pageNumber.textContent = i;
        pageNumber.className = 'page-number';
        if (i === currentPage) {
            pageNumber.classList.add('active');
        }
        pageNumber.addEventListener('click', () => {
            currentPage = i;
            renderTable();
        });
        pageNumbers.appendChild(pageNumber);
    }
}

document.getElementById('prevPage').addEventListener('click', () => {
    if (currentPage > 1) {
        currentPage--;
        renderTable();
    }
});

document.getElementById('nextPage').addEventListener('click', () => {
    const totalPages = Math.ceil(users.length / rowsPerPage);
    if (currentPage < totalPages) {
        currentPage++;
        renderTable();
    }
});

document.getElementById('searchBtn').addEventListener('click', () => {
    const searchValue = document.getElementById('search').value.toLowerCase();
    const filteredUsers = users.filter(user => user.id.toLowerCase().includes(searchValue));
    if (filteredUsers.length > 0) {
        renderSearchResults(filteredUsers);
    } else {
        alert('User not found');
    }
});

function renderSearchResults(filteredUsers) {
    const tbody = document.getElementById('userTableBody');
    tbody.innerHTML = '';

    filteredUsers.forEach(user => {
        const row = document.createElement('tr');
        Object.values(user).forEach(value => {
            const cell = document.createElement('td');
            cell.textContent = value;
            row.appendChild(cell);
        });
        const manageCell = document.createElement('td');
        const manageButton = document.createElement('button');
        manageButton.textContent = '관리';
        manageButton.className = 'manage';
        manageCell.appendChild(manageButton);
        row.appendChild(manageCell);
        tbody.appendChild(row);
    });
}

renderTable();
