
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
