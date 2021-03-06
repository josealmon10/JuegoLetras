package juegoletras;

public class GeneradorLetras {
    
    public GeneradorLetras(){
        
    }
    
    /**
     * Genera una letra aletoria en funcion en el nivel que estemos
     * @param game Nivel de juego
     * @return Letra generada
     */
    public char generarLetra(int game){
        char let=(char)Math.floor(Math.random()*(90-65)+65);
        switch(game){
            case 1:
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 2:
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ' || let=='Q' 
                            || let=='W' || let=='O' || let=='P'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 3:
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ' || let=='Q' 
                            || let=='W' || let=='O' || let=='P'  || let=='Z'  || let=='X'  || let=='N' || let=='M'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 4:
                while(true){
                    if(let=='A' || let=='S' || let=='D' || let=='F' || let=='J' || let=='K' || let=='L' || let=='Ñ' || let=='Q' 
                            || let=='W' || let=='O' || let=='P'  || let=='Z'  || let=='X'  || let=='N' || let=='M' || let=='E' 
                            || let=='C' || let=='I' || let=='B'){
                        break;
                    }else{
                        let=(char)Math.floor(Math.random()*(90-65)+65);
                    }
                }
                break;
            case 5:
                if((int)Math.floor(Math.random()*(3-1)+1)==1){
                    let=(char)Math.floor(Math.random()*(90-65)+65);
                }else{
                    let=(char)Math.floor(Math.random()*(57-48)+48);
                }
                break;
        }
        return let;
    }
}