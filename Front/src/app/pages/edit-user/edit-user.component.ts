import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit(): void {
    if(window.localStorage.getItem("usuario") != "visitante") {
      this._router.navigateByUrl('/home');
    }
    window.localStorage.setItem("url", "edit-user");
  }

}
