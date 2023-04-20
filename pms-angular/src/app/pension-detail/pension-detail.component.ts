import { HttpClient, HttpHeaders } from '@angular/common/http';
import { SafeKeyedRead } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { CookieService } from '../cookie.service';
import { PmsLoginComponent } from '../pms-login/pms-login.component';


@Component({
  selector: 'app-pension-detail',
  templateUrl: './pension-detail.component.html',
  styleUrls: ['./pension-detail.component.css']
})
export class PensionDetailComponent implements OnInit {

  showPensioner = false;
  showPension = false;
  showAlert=false;

  aadhaarNumber = "";
  aadhaarNumber2 = "";
  pname = "";
  dob = new Date();
  pan_number = "";
  bank_detail = {
    bank_name: "",
    account_number: "",
  };

  pensionAmount = 0;
  bankServiceCharge = 0;

  constructor(private http: HttpClient, public cookie: CookieService) {
  }

  ngOnInit(): void {
  }

  showPensionerDetails() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': "Bearer " + this.cookie.getCookie("accessToken")
    });
    this.http.get(
      `http://localhost:8080/PensionerDetailByAadhaar?aadhaarNumber=${this.aadhaarNumber}`,
      { headers: headers, withCredentials: true }
    ).subscribe((responseData: any) => {
      console.log(responseData);
      console.log(responseData.message == "Record found !")

      if (responseData.message == "Record found !") {
        this.showAlert=false;
        this.showPensioner = true;
        this.aadhaarNumber2 = this.aadhaarNumber;
        this.pname = responseData.data.name;
        this.dob = new Date(responseData.data.dob);
        this.pan_number = responseData.data.panNumber;
        this.bank_detail.account_number = responseData.data.accountNumber;
        this.bank_detail.bank_name = responseData.data.bankName;
      } else {
        this.showAlert=true;
        this.showPensioner = false;
      }
    });
    this.showPension = false;
    console.log("add ", this.aadhaarNumber);
  }

  showPensionDetail() {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': "Bearer " + this.cookie.getCookie("accessToken")
    });

    var postData = { aadhaarNumber: this.aadhaarNumber2 };
    this.http
      .post(
        'http://localhost:8081/ProcessPension',
        postData,
        { headers: headers, withCredentials: true }
      )
      .subscribe((responseData: any) => {
        console.log(responseData);
        this.pensionAmount = responseData.pensionAmount;
        this.bankServiceCharge = responseData.bankServiceCharge;
      });
    this.showAlert = false;
    this.showPension = true;
  }

}
