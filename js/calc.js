function Validity(loanAmount, interestRate, tenure) {
    if (loanAmount == "" || interestRate == "" || tenure == "") {
      alert("invalid inputs.");
      return false;
    } else {
      return true;
    }
  }

  function Calculate() {
    var loanAmount = document.getElementById("Loan_amount").value;
    var interestRate = document.getElementById("Interest_rate").value;
    var tenure = document.getElementById("Tenure").value;

    if (Validity(loanAmount, interestRate, tenure)) {
      loanAmount = parseInt(loanAmount);
      interestRate = parseInt(interestRate);
      tenure = parseInt(tenure);

      var CI = calculateCompoundInterest(
        loanAmount,
        interestRate,
        tenure
      ).toFixed(2);

      var tag = document.createElement("p");
      var text = document.createTextNode(
        `Total Amount to be paid is ${CI}`
      );

      tag.appendChild(text);

      const value = document.getElementById("ResultHere");
      if (value.firstElementChild != null) {
        value.removeChild(value.firstElementChild);
      }

      console.log(CI);

      document.getElementById("ResultHere").appendChild(tag);
    }
  }

  function Yearly() {
    var loanAmount = document.getElementById("Loan_amount").value;
    var interestRate = document.getElementById("Interest_rate").value;
    var tenure = document.getElementById("Tenure").value;

    if (Validity(loanAmount, interestRate, tenure)) {
      loanAmount = parseInt(loanAmount);
      interestRate = parseInt(interestRate);
      tenure = parseInt(tenure);

      var CI = calculateCompoundInterest(
        loanAmount,
        interestRate,
        tenure
      ).toFixed(2);

      const value = document.getElementById("ResultHere");
      if (value.firstElementChild != null) {
        value.removeChild(value.firstElementChild);
      }

      let table = document.createElement("table");
      table.classList.add("table");
      table.classList.add("table-light");
      let thead = document.createElement("thead");
      let tbody = document.createElement("tbody");

      table.appendChild(thead);
      table.appendChild(tbody);

      // Adding the entire table to the body tag
      document.getElementById("ResultHere").appendChild(table);

      let row_1 = document.createElement("tr");
      let heading_1 = document.createElement("th");
      heading_1.innerHTML = "Sr. No.";
      let heading_2 = document.createElement("th");
      heading_2.innerHTML = "Yearly Payment";
      let heading_3 = document.createElement("th");
      heading_3.innerHTML = "Interest Occured";

      row_1.appendChild(heading_1);
      row_1.appendChild(heading_2);
      row_1.appendChild(heading_3);
      thead.appendChild(row_1);

      for (var i = 0; i < tenure; i++) {
        let row_2 = document.createElement("tr");
        let row_2_data_1 = document.createElement("td");
        row_2_data_1.innerHTML = i + 1;
        let row_2_data_2 = document.createElement("td");
        row_2_data_2.innerHTML = (CI / tenure).toFixed(2);
        let row_2_data_3 = document.createElement("td");
        row_2_data_3.innerHTML = (
          CI / tenure -
          loanAmount / tenure
        ).toFixed(2);

        row_2.appendChild(row_2_data_1);
        row_2.appendChild(row_2_data_2);
        row_2.appendChild(row_2_data_3);
        tbody.appendChild(row_2);
      }
    }
  }

  function MonthlyWise() {
    var loanAmount = document.getElementById("Loan_amount").value;
    var interestRate = document.getElementById("Interest_rate").value;
    var tenure = document.getElementById("Tenure").value;

    if (Validity(loanAmount, interestRate, tenure)) {
      loanAmount = parseInt(loanAmount);
      interestRate = parseInt(interestRate);
      tenure = parseInt(tenure);

      var CI = calculateCompoundInterest(
        loanAmount,
        interestRate,
        tenure
      ).toFixed(2);

      const value = document.getElementById("ResultHere");
      if (value.firstElementChild != null) {
        value.removeChild(value.firstElementChild);
      }

      let table = document.createElement("table");
      table.classList.add("table");
      table.classList.add("table-light");
      let thead = document.createElement("thead");
      let tbody = document.createElement("tbody");

      table.appendChild(thead);
      table.appendChild(tbody);

      // Adding the entire table to the body tag
      document.getElementById("ResultHere").appendChild(table);

      let row_1 = document.createElement("tr");
      let heading_1 = document.createElement("th");
      heading_1.innerHTML = "Sr. No.";
      let heading_2 = document.createElement("th");
      heading_2.innerHTML = "Monthly Payment";
      let heading_3 = document.createElement("th");
      heading_3.innerHTML = "Interest Occured";

      row_1.appendChild(heading_1);
      row_1.appendChild(heading_2);
      row_1.appendChild(heading_3);
      thead.appendChild(row_1);

      for (var i = 0; i < tenure * 12; i++) {
        let row_2 = document.createElement("tr");
        let row_2_data_1 = document.createElement("td");
        row_2_data_1.innerHTML = i + 1;
        let row_2_data_2 = document.createElement("td");
        row_2_data_2.innerHTML = (CI / tenure).toFixed(2);
        let row_2_data_3 = document.createElement("td");
        row_2_data_3.innerHTML = (
          CI / (tenure * 12) -
          loanAmount / (tenure * 12)
        ).toFixed(2);

        row_2.appendChild(row_2_data_1);
        row_2.appendChild(row_2_data_2);
        row_2.appendChild(row_2_data_3);
        tbody.appendChild(row_2);
      }
    }
  }

  function calculateCompoundInterest(loanAmount, interestRate, tenure) {
    const rate = interestRate / 100;
    let val = Math.pow(1 + rate / 12, tenure * 12);
    return loanAmount * val;
  }

  function generateTable(table, data) {
    for (let element of data) {
      let row = table.insertRow();
      for (key in element) {
        let cell = row.insertCell();
        let text = document.createTextNode(element[key]);
        cell.appendChild(text);
      }
    }
  }