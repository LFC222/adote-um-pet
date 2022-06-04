import { AxiosError } from 'axios';
import {
    useState,
    useEffect
} from 'react';
import { Pet } from '../../@types/pets';
import { ApiService } from '../../services/apiService';

export function useIndex(){

    const [listaPets, setListaPets] = useState<Pet[]>([]),

        [petSelected, setPetSelected] = useState<Pet | null>(null),
        [email, setEmail] = useState(''),
        [valor, setValor] = useState(''),
        [message, setMessage] = useState('');


    useEffect(() => {
        ApiService.get('/pets')
            .then((response) => {
                setListaPets(response.data);
            })
    },[])

    useEffect(() => {
        if(petSelected === null){
            limparForm();
        }
    },[petSelected])

    function Adotar(){
        if(petSelected != null){
            if(validarDadosAdocao()){
                ApiService.post('/adocoes',{
                    pet_id : petSelected.id,
                    email : email,
                    valor : valor
                })
                    .then(() => {
                        setPetSelected(null);
                        setMessage('Pet adotado com sucesso!');
                    })
                        .catch((error : AxiosError) => {
                            setMessage(error.response?.data.message);
                        })
            }else{
                setMessage('Preencha os campos corretamente!')
            }
        }
    }

    function validarDadosAdocao(){
        return email.length > 0 && valor.length > 0;
    }

    function limparForm(){
        setEmail('');
        setValor('');
    }

    return {
        listaPets,
        petSelected,
        setPetSelected,
        email,
        setEmail,
        valor,
        setValor,
        message,
        setMessage,
        Adotar
    };
}