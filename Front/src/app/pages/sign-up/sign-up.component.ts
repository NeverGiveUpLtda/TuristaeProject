import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  tipoCadastro: string = "1";

  constructor(private _router: Router) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("usuario")) {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "sign-up");
  }

}
