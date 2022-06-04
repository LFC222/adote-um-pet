import { Button } from "@mui/material";
import { Pet } from "../../../data/@types/pets";
import { 
ListStyled,
ItemList,
Foto,
Information,
Name,
Description
 } from "./style";
 import {TextService} from '../../../data/services/textService';

 interface ListProps{
     pets: Pet[];
     onSelect: (pet : Pet) => void;
 }

 export default function List(props : ListProps){

    const tamanhoMaximoText = 200;

     return(
         <ListStyled>
            {props.pets.map(pet => (
            <ItemList key={pet.id}>
                 <Foto src={pet.foto} alt={pet.nome}/>
                 <Information>
                     <Name>{pet.nome}</Name>
                     <Description>
                         {TextService.limitarTexto(pet.historia,tamanhoMaximoText)}
                     </Description>
                     <Button 
                        variant={'contained'}
                        fullWidth
                        onClick={() => props.onSelect(pet)}
                    >
                        Adotar {pet.nome}
                    </Button>
                 </Information>
             </ItemList>
         ))} 
         </ListStyled>
     );
 }