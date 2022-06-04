import type { NextPage } from 'next';
import List from '../ui/components/List/List';
import Title from '../ui/components/Title/Title';
import {
Dialog,
TextField,
Grid,
DialogActions,
Button,
Snackbar
} from '@mui/material';
import { useIndex } from '../data/hooks/pages/useIndex';

const Home: NextPage = () => {
  const{ 
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
  } = useIndex();

  return (
    <div>

      <Title 
        title=""
        subtitle={
          <span>
            Com um pequeno valor mensal, você<br/>
            pode <strong>adotar um pet virtualmente.</strong>
          </span>
        }
      />

      <List
        pets = {listaPets}
        onSelect = {(pet) => setPetSelected(pet)}
      />

      <Dialog 
        open={petSelected !== null}
        fullWidth
        PaperProps={{sx : {p: 5}}}
        onClose={() => setPetSelected(null)}
      >

        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField 
              label={'email'}
              type={'email'}
              fullWidth
              value = {email}
              onChange = {(e) => setEmail(e.target.value)}
            />
          </Grid>

          <Grid item xs={12}>
            <TextField 
              label={'Quantia por mês'}
              type={'number'}
              fullWidth
              value = {valor}
              onChange = {(v) => setValor(v.target.value)}
            />
          </Grid>

        </Grid>

        <DialogActions sx={{mt : 5}}>
          <Button 
            color={'secondary'}
            onClick={() => setPetSelected(null)}
          >
            Cancelar
          </Button>
          <Button
            variant={'contained'}
            onClick = {() => Adotar()}
          >
            Confirmar Adoção
          </Button>
        </DialogActions>

      </Dialog>

      <Snackbar
        open={message.length > 0}
        message={message}
        autoHideDuration = {2500}
        onClose = {() => setMessage('')}
      />

    </div>
  )
}

export default Home
