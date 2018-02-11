function validateRegistrationForm() {
    var login = document.forms["registration"]["login"].value;
    if (login == "") {
        alert("login must be filled out");
        return false;
    }
    var password = document.forms["registration"]["password"].value;
    if (password == "") {
        alert("password must be filled out");
        return false;
    }
    var firstName = document.forms["registration"]["firstName"].value;
    if (firstName == "") {
        alert("firstName must be filled out");
        return false;
    }
    var lastName = document.forms["registration"]["lastName"].value;
    if (lastName == "") {
        alert("lastName must be filled out");
        return false;
    }
    var surname = document.forms["registration"]["surname"].value;
    if (surname == "") {
        alert("surname must be filled out");
        return false;
    }
    var pasportSeria = document.forms["registration"]["pasportSeria"].value;
    if (pasportSeria == "") {
        alert("pasportSeria must be filled out");
        return false;
    }
    var pasportNomer = document.forms["registration"]["pasportNomer"].value;
    var pasNumPat = /[0-9]{7}/i;
    if (!pasNumPat.test(pasportNomer)) {
        alert("pasportNomer must be filled out");
        return false;
    }

    var identificationNumber = document.forms["registration"]["identificationNumber"].value;
    if (identificationNumber == "") {
        alert("identificationNumber must be filled out");
        return false;
    }
    var dataOfBirth = document.forms["registration"]["dataOfBirth"].value;
    if (dataOfBirth == "") {
        alert("Wrong dataOfBirth");
        return false;
    }

    var nationality = document.forms["registration"]["nationality"].value;
    if (nationality == "") {
        alert("nationality must be filled out");
        return false;
    }
    var residenceAddress = document.forms["registration"]["residenceAddress"].value;
    if (residenceAddress == "") {
        alert("residenceAddress must be filled out");
        return false;
    }
    var score = document.forms["registration"]["score"].value;
    if (score == "") {
        alert("score must be filled out");
        return false;
    }
    var goldMedal = document.forms["registration"]["goldMedal"].value;
    if (goldMedal == "") {
        alert("goldMedal must be filled out");
        return false;
    }
    var email = document.forms["registration"]["email"].value;
    if (email == "") {
        alert("email must be filled out");
        return false;
    }
    var telephoneNumber = document.forms["registration"]["telephoneNumber"].value;
    if (telephoneNumber == "") {
        alert("telephoneNumber must be filled out");
        return false;
    }

    var subjectOneValue = document.forms["registration"]["subjectOneValue"].value;
    if (subjectOneValue == "" || subjectOneValue < 15 || subjectOneValue > 100) {
        alert("subjectOneValue must be filled out");
        return false;
    }

    var subjectTwoValue = document.forms["registration"]["subjectTwoValue"].value;
    if (subjectTwoValue == "" || subjectTwoValue < 15 || subjectTwoValue > 100) {
        alert("subjectTwoValue must be filled out");
        return false;
    }

    var subjectThreeValue = document.forms["registration"]["subjectThreeValue"].value;
    if (subjectThreeValue == "" || subjectThreeValue < 15 || subjectThreeValue > 100) {
        alert("subjectThreeValue must be filled out");
        return false;
    }
    var subjectOneId = document.forms["registration"]["subjectOneId"].value;
    var subjectTwoId = document.forms["registration"]["subjectTwoId"].value;
    var subjectThreeId = document.forms["registration"]["subjectThreeId"].value;

    if (subjectThreeId == subjectOneId || subjectOneId == subjectTwoId || subjectTwoId == subjectThreeId) {
        alert("subject must be filled out");
        return false;
    }
}

function validateChangePersonalInformation() {
    var firstName = document.forms["changePersonalInformation"]["firstName"].value;
    if (firstName == "") {
        alert("firstName must be filled out");
        return false;
    }
    var lastName = document.forms["changePersonalInformation"]["lastName"].value;
    if (lastName == "") {
        alert("lastName must be filled out");
        return false;
    }
    var surname = document.forms["changePersonalInformation"]["surname"].value;
    if (surname == "") {
        alert("surname must be filled out");
        return false;
    }
    var pasportSeria = document.forms["changePersonalInformation"]["pasportSeria"].value;
    if (pasportSeria == "") {
        alert("pasportSeria must be filled out");
        return false;
    }
    var pasportNomer = document.forms["changePersonalInformation"]["pasportNomer"].value;
    var pasNumPat = /[0-9]{7}/i;
    if (!pasNumPat.test(pasportNomer)) {
        alert("pasportNomer must be 7 numbers");
        return false;
    }
    var dataOfIssue = document.forms["changePersonalInformation"]["dataOfIssue"].value;
//начало строки, символы от одного до бесконечности, @, опять символы от одного до бесконечности, точка,
//от двух до четырёх символов (если почта где-нибудь на .info), конец строки (регистр нк учитывается)
    if (dataOfIssue == "") {
        alert("Wrong dataOfIssue");
        return false;
    }
    var identificationNumber = document.forms["changePersonalInformation"]["identificationNumber"].value;
    if (identificationNumber == "") {
        alert("identificationNumber must be filled out");
        return false;
    }
    var dataOfBirth = document.forms["changePersonalInformation"]["dataOfBirth"].value;
//начало строки, символы от одного до бесконечности, @, опять символы от одного до бесконечности, точка,
//от двух до четырёх символов (если почта где-нибудь на .info), конец строки (регистр нк учитывается)
    if (dataOfBirth == "") {
        alert("Wrong dataOfBirth");
        return false;
    }

    var nationality = document.forms["changePersonalInformation"]["nationality"].value;
    if (nationality == "") {
        alert("nationality must be filled out");
        return false;
    }
    var residenceAddress = document.forms["changePersonalInformation"]["residenceAddress"].value;
    if (residenceAddress == "") {
        alert("residenceAddress must be filled out");
        return false;
    }
    var scope = document.forms["changePersonalInformation"]["scope"].value;
    if (scope == "") {
        alert("scope must be filled out");
        return false;
    }
    var goldMedal = document.forms["changePersonalInformation"]["goldMedal"].value;
    if (goldMedal == "") {
        alert("goldMedal must be filled out");
        return false;
    }
    var email = document.forms["changePersonalInformation"]["email"].value;
    if (email == "") {
        alert("email must be filled out");
        return false;
    }
    var telephoneNumber = document.forms["changePersonalInformation"]["telephoneNumber"].value;
    if (telephoneNumber == "") {
        alert("telephoneNumber must be filled out");
        return false;
    }

}

function validateChangeSubject() {
    var subjectName = document.forms["changeSubject"]["subjectName"].value;
    if (subjectName == "") {
        alert("name must be filled out");
        return false;
    }
}

function validateChangeSpeciality() {
    var specialityId = document.forms["changeSpeciality"]["specialityId"].value;
    if (specialityId == "") {
        alert("specialityId must be filled out");
        return false;
    }
    var specialityName = document.forms["changeSpeciality"]["specialityName"].value;
    if (specialityName == "") {
        alert("specialityName must be filled out");
        return false;
    }
    var facultyId = document.forms["changeSpeciality"]["facultyId"].value;
    if (facultyId == "") {
        alert("facultyId must be filled out");
        return false;
    }
    var numberBudgetPlace = document.forms["changeSpeciality"]["numberBudgetPlace"].value;
    if (numberBudgetPlace == "") {
        alert("numberBudgetPlace must be filled out");
        return false;
    }
    var numberPaidPlace = document.forms["changeSpeciality"]["numberPaidPlace"].value;
    if (numberPaidPlace == "") {
        alert("numberPaidPlace must be filled out");
        return false;
    }
}

function validateChangeFaculty() {
    var nameFaculty = document.forms["changeFaculty"]["nameFaculty"].value;
    if (nameFaculty == "") {
        alert("nameFaculty must be filled out");
        return false;
    }
    var startDate = document.forms["changeFaculty"]["startDate"].value;
    if (startDate == "") {
        alert("startDate must be filled out");
        return false;
    }
    var endDate = document.forms["changeFaculty"]["endDate"].value;
    if (endDate == "") {
        alert("facultyId must be filled out");
        return false;
    }
    var subjectOneId = document.forms["changeFaculty"]["subjectOneId"].value;
    var subjectTwoId = document.forms["changeFaculty"]["subjectTwoId"].value;
    var subjectThreeId = document.forms["changeFaculty"]["subjectThreeId"].value;
    if (subjectThreeId == subjectOneId || subjectOneId == subjectTwoId || subjectTwoId == subjectThreeId) {
        alert("subject must be filled out");
        return false;
    }

}

function validateAdminInformation() {
    var surname = document.forms["changeAdminInform"]["surname"].value;
    if (surname == "") {
        alert("surname must be filled out");
        return false;
    }
    var firstName = document.forms["changeAdminInform"]["firstName"].value;
    if (firstName == "") {
        alert("firstName must be filled out");
        return false;
    }
    var lastName = document.forms["changeAdminInform"]["lastName"].value;
    if (lastName == "") {
        alert("lastName must be filled out");
        return false;
    }
}

function validateCrateAdmin() {
    var login = document.forms["createAdmin"]["login"].value;
    if (login == "") {
        alert("login must be filled out");
        return false;
    }
    var password = document.forms["createAdmin"]["password"].value;
    if (password == "") {
        alert("password must be filled out");
        return false;
    }
    var surname = document.forms["createAdmin"]["surname"].value;
    if (surname == "") {
        alert("surname must be filled out");
        return false;
    }
    var firstName = document.forms["createAdmin"]["firstName"].value;
    if (firstName == "") {
        alert("firstName must be filled out");
        return false;
    }
    var lastName = document.forms["createAdmin"]["lastName"].value;
    if (lastName == "") {
        alert("lastName must be filled out");
        return false;
    }
}

function validateCreateFaculty() {
    var nameFaculty = document.forms["createFaculty"]["nameFaculty"].value;
    if (nameFaculty == "") {
        alert("nameFaculty must be filled out");
        return false;
    }
    var startDate = document.forms["createFaculty"]["startDate"].value;
    if (startDate == "") {
        alert("startDate must be filled out");
        return false;
    }
    var endDate = document.forms["createFaculty"]["endDate"].value;
    if (endDate == "") {
        alert("endDate must be filled out");
        return false;
    }
    var subjectOneId = document.forms["createFaculty"]["subjectOneId"].value;
    var subjectTwoId = document.forms["createFaculty"]["subjectTwoId"].value;
    var subjectThreeId = document.forms["createFaculty"]["subjectThreeId"].value;
    if (subjectThreeId == subjectOneId || subjectOneId == subjectTwoId || subjectTwoId == subjectThreeId) {
        alert("subject must be filled out");
        return false;
    }

}

function validateCreateSpeciality() {
    var specialityName = document.forms["createSpeciality"]["specialityName"].value;
    if (specialityName == "") {
        alert("specialityName must be filled out");
        return false;
    }
    var facultyId = document.forms["createSpeciality"]["facultyId"].value;
    if (facultyId == "") {
        alert("facultyId must be filled out");
        return false;
    }
    var numberBudgetPlace = document.forms["createSpeciality"]["numberBudgetPlace"].value;
    if (numberBudgetPlace == "") {
        alert("numberBudgetPlace must be filled out");
        return false;
    }
    var numberPaidPlace = document.forms["createSpeciality"]["numberPaidPlace"].value;
    if (numberPaidPlace == "") {
        alert("numberPaidPlace must be filled out");
        return false;
    }
}

function validateCreateSubject() {
    var subjectName = document.forms["createSubject"]["subjectName"].value;
    if (subjectName == "") {
        alert("name must be filled out");
        return false;
    }
}
