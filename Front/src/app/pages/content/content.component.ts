import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
	images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);
  constructor() { }

  ngOnInit(): void {
    window.localStorage.setItem("url", "home");
  }

}
