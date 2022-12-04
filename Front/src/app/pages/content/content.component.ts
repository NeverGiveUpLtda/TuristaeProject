import { Component, OnInit } from '@angular/core';
import { TurismoService } from '../../services/turismo.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {
	images = [944, 1011, 984].map((n) => `https://picsum.photos/id/${n}/900/500`);

  listaDeListas: any[] = [];
  listaDeTurismos: any[] = [];

  constructor(private _turismo: TurismoService) { }

  ngOnInit(): void {
    window.localStorage.setItem("url", "home");
    this.buscarTurismos();
  }

  buscarTurismos(): void {
    this._turismo.buscarTurismos().subscribe((turismos: any) => {
      this.listaDeTurismos = turismos;
      this.separarTurismos();
      console.log("Lista de turismos: ", this.listaDeTurismos);
      this.listaDeListas.forEach((turismos4: any) => {
        console.log(turismos4[0]);
      });
    });
  }

  separarTurismos(): void {
    let contador: number = 0;
    let turismos4: any[] = [];
    this.listaDeTurismos.forEach((turismo: any) => {
      turismos4[contador] = turismo;
      if(contador === 3) {
        this.listaDeListas.push(turismos4);
        turismos4 = [];
        contador = 0;
      } else
        contador++;

        if(this.listaDeTurismos.length < 4) {
          this.listaDeListas.push(turismos4);
          turismos4 = [];
          contador = 0;
        }
    });
  }
}
