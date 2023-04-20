import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CookieService } from '../cookie.service';

@Component({
  selector: 'app-pms-login',
  templateUrl: './pms-login.component.html',
  styleUrls: ['./pms-login.component.css']
})
export class PmsLoginComponent implements OnInit {

  username = "";
  password = "";
  constructor(private http: HttpClient, public cookie: CookieService, private router: Router) { }

  ngOnInit(): void {
  }

  authenticate() {
    var payload = { email: this.username, password: this.password };
    this.http.post("http://localhost:8082/auth/login", payload)
      .subscribe((response: any) => {
        console.log(response.accessToken);
        this.cookie.setCookie({
          name: 'accessToken',
          value: response.accessToken,
          session: true,
        });
        this.router.navigate(['/pension']);
      })
  }

}
