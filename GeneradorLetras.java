<<<<<<< HEAD

package juegoletras;

public class GeneradorLetras {
    
    public GeneradorLetras(){
        
    }
    
    public char generarLetra(int game){
        char let='.';
        switch(game){
            case 1:
                let=(char)Math.floor(Math.random()*(90-65)+65);
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 2:
                let=(char)Math.floor(Math.random()*(90-65)+65);
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ' || let=='Q' || let=='W' || let=='O' || let=='P'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 3:
                let=(char)Math.floor(Math.random()*(90-65)+65);
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ' || let=='Q' || let=='W' || let=='O' || let=='P'  || let=='Z'  || let=='X'  || let=='N' || let=='M'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 4:
                let=(char)Math.floor(Math.random()*(90-65)+65);
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ' || let=='Q' || let=='W' || let=='O' || let=='P'  || let=='Z'  || let=='X'  || let=='N' || let=='M' || let=='E' || let=='C' || let=='I' || let=='B'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 5:
                let=(char)Math.floor(Math.random()*(90-65)+65);
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ' || let=='Q' || let=='W' || let=='O' || let=='P'  || let=='Z'  || let=='X'  || let=='N' || let=='M' || let=='E' || let=='C' || let=='I' || let=='B' || let=='R' || let=='V' || let=='U' || let=='H'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 6:
                let=(char)Math.floor(Math.random()*(90-65)+65);
                break;
        }
        return let;
    }
}
=======

package juegoletras;

public class GeneradorLetras {
    
    public GeneradorLetras(){
        
    }
    
    public char generarLetra(int game){
        char let='.';
        switch(game){
            case 1:
                let=(char)Math.floor(Math.random()*(90-65)+65);
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 2:
                let=(char)Math.floor(Math.random()*(90-65)+65);
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 5:
            
                break;
        }
        return let;
    }
}
>>>>>>> master
